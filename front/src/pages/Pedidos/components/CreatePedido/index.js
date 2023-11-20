import React, { useEffect, useState } from "react";
import { IoTrash } from "react-icons/io5";
import apiService from "../../../../services";
import { formatNumberToCop, showAlert } from "../../../../utilities";
import "../../../../css/createPedidoVenta.css";
import "../../../../css/botones.css";

const CreatePedido = ({actualizarListaPedidos}) => {
  // Estado para almacenar la lista de productos y los productos agregados al carrito
  const [productos, setProductos] = useState([]);
  const [productosAgregados, setProductosAgregados] = useState({});

  const [modalVisible, setModalVisible] = useState(false);
  const [descripcionPedido, setDescripcionPedido] = useState('');


  // Efecto para cargar la lista de productos al montar el componente
  useEffect(() => {
    apiService
      .getProductos()
      .then((response) => {
        setProductos(response);
      })
      .catch(() => {
        showAlert(
          "error",
          "Conexión Fallida",
          "No se pudieron cargar correctamente los productos"
        );
      });
  }, []);

  // Función para manejar la adición de un producto al carrito
const handleAgregarProducto = (e, productoId, nombre, precio) => {
  // Prevenir el comportamiento predeterminado del evento (por ejemplo, recargar la página)
  e.preventDefault();

  // Verificar si el producto ya está en el carrito
  if (productosAgregados.hasOwnProperty(productoId)) {
    // Si el producto ya está en el carrito, actualizar la cantidad
    setProductosAgregados((prevProductos) => ({
      ...prevProductos,
      [productoId]: {
        ...prevProductos[productoId],
        cantidad: prevProductos[productoId].cantidad + 1,
      },
    }));
  } else {
    // Si el producto no está en el carrito, agregarlo con una cantidad inicial de 1
    setProductosAgregados((prevProductos) => ({
      ...prevProductos,
      [productoId]: {
        id: productoId,
        nombre: nombre,
        precio: precio,
        cantidad: 1,
      },
    }));
  }
};


  // Función para agregar cantidad a un producto en el carrito
  const handleAgregarCantidad = (e, productoId) => {
    e.preventDefault();

    setProductosAgregados((prevProductos) => ({
      ...prevProductos,
      [productoId]: {
        ...prevProductos[productoId],
        cantidad: prevProductos[productoId].cantidad + 1,
      },
    }));
  };

  // Función para determinar si el carrito está vacío
  const isCarritoVacio = Object.keys(productosAgregados).length === 0;


  // Función para quitar cantidad de un producto en el carrito
  const handleQuitarCantidad = (e, productoId) => {
    e.preventDefault();

    setProductosAgregados((prevProductos) => {
      const newProductos = { ...prevProductos };
      if (newProductos[productoId].cantidad > 1) {
        newProductos[productoId].cantidad -= 1;
      } else {
        delete newProductos[productoId];
      }
      return newProductos;
    });
  };

  // Función para calcular el total de la compra
  const calcularTotal = () => {
    let total = 0;
    for (let key in productosAgregados) {
      if (productosAgregados.hasOwnProperty(key)) {
        let producto = productosAgregados[key];
        let cantidad = producto.cantidad;
        let precio = parseInt(producto.precio);
        total += cantidad * precio;
      }
    }
    return total;
  };

  // Abrir modal de preferencias
  const abrirModal = () => {
    setModalVisible(true);
  };
  const guardarPreferencias = () => {
    // Aquí puedes realizar acciones con la descripciónPedido
    // Por ejemplo, puedes guardarla en el estado o realizar cualquier otra lógica que necesites.
    setModalVisible(false)
  };
  
  

  // Función para crear un nuevo pedido
  const handleCrearPedido = async () => {
    try {
      // Detalles del pedido
      setDescripcionPedido(descripcionPedido ? descripcionPedido : "Sin descripción");
      const fechaActual = new Date();
      const año = fechaActual.getFullYear();
      const mes = ('0' + (fechaActual.getMonth() + 1)).slice(-2); // Suma 1 porque los meses van de 0 a 11
      const dia = ('0' + fechaActual.getDate()).slice(-2);

      const fechaPedido = `${año}-${mes}-${dia}`;
      const estadoPedidoId = 1;
      const noDocumentoUsuario = 1234567893;
  
      // Crear el pedido
      const createdPedido = await apiService.createPedido({
        descripcionPedido,
        fechaPedido,
        estadoPedido: { idEstadoPedido: estadoPedidoId },
        usuario: { noDocumentoUsuario },
      });
  
      // Crear detallesPedidos
      const detallesPedidosPromises = Object.values(productosAgregados).map(
        (producto) =>
          apiService.createDetallePedido({
            cantidadProducto: producto.cantidad,
            subtotalDetallePedido: producto.cantidad * producto.precio,
            producto: { idProducto: producto.id },
            pedido: { idPedido: createdPedido.idPedido },
            estado: true,
          })
      );
  
      // Esperar a que se creen todos los detallesPedidos
      await Promise.all(detallesPedidosPromises);
      
      actualizarListaPedidos();

      // Mostrar alerta de éxito
      showAlert(
        "success",
        "Pedido Creado",
        "Gracias por crear su pedido con nosotros"
      );
  
      // Limpiar el carrito después de crear el pedido
      setProductosAgregados({});
      setDescripcionPedido("");
      document.getElementById("CloseModal").click();

  
    } catch (error) {
      console.error("Error al crear el pedido:", error);
      // Manejar el error adecuadamente
    }
  };

  // Renderización del componente
  return (
    <>
      <div className="d-flex">
        <div data-bs-dismiss="modal" aria-label="Close" id="CloseModal"></div>
        <div className="catalogo">
          {/* Renderizar la lista de productos disponibles */}
          {productos.map((producto) => (
            <div className="card" style={{ width: "18rem" }} key={producto.idProducto}>
              <div className="card-body">
                <h5 className="card-title nombre_Producto">{producto.nombreProducto}</h5>
                <p className="card-title precio_Producto">{formatNumberToCop(producto.precioProducto)}</p>
                <a
                  href="#"
                  className="btn agregar-producto"
                  data-producto-id={producto.idProducto}
                  onClick={(e) =>
                    handleAgregarProducto(
                      e,
                      producto.idProducto,
                      producto.nombreProducto,
                      producto.precioProducto
                    )
                  }
                >
                  Agregar
                </a>
              </div>
            </div>
          ))}
        </div>
        <div className="carrito">
          {/* Renderizar la lista de productos en el carrito */}
          <div className="d-flex justify-content-between w-100">
            <h2 className="titulo">Carrito</h2>
            <button className="btn btn-trash px-1" onClick={()=>setProductosAgregados({})} disabled={isCarritoVacio}>
              <IoTrash/>
            </button>
          </div>
          <div className="carrito__productos">
            {Object.keys(productosAgregados).map((key) => {
              const producto = productosAgregados[key];
              return (
                <div className="card" key={key} data-producto-id={key}>
                  <div className="card-body">
                    {/* Botones para incrementar y decrementar la cantidad de un producto */}
                    <button
                      className="btn btn-quitar"
                      onClick={(e) => handleQuitarCantidad(e, key)}
                    >
                      -
                    </button>
                    <div className="descripcion">
                      <h5 className="card-title">{producto.nombre}</h5>
                      <p className="card-title">$ {producto.precio}</p>
                      <span className="badge bg-secondary">{producto.cantidad}</span>
                    </div>
                    <button
                      className="btn btn-agregar"
                      onClick={(e) => handleAgregarCantidad(e, key)}
                    >
                      +
                    </button>
                  </div>
                </div>
              );
            })}
          </div>
          {/* Mostrar el total de la compra */}
          <div className="carrito__footer">
            <h2>Total</h2>
            <p id="total-precio">${calcularTotal().toLocaleString()}</p>
          </div>
          {/* Botón para crear el pedido o vaciar carrito */}
            <div className="d-flex flex-wrap w-100 justify-content-between gap-1">
              <button className="btn" onClick={abrirModal}>
                + Preferencias
              </button>

              <button className="btn btn-excel" id="crear-pedido" onClick={handleCrearPedido} disabled={isCarritoVacio}>
                Crear Pedido
              </button>
            </div>
        </div>
      </div>
      {/* Modal para preferencias */}
      <div className="modal" tabIndex="-1" style={{ display: modalVisible ? 'block' : 'none' }}>
        <div className="modal-dialog modal-dialog-centered">
          <div className="modal-content">
            <div className="modal-header d-flex align-items-start">
              <h5 className="modal-title">Preferencias del Pedido</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={() => setModalVisible(false)}>
                <p style={{fontFamily: "arial"}}>x</p>
              </button>
            </div>
            <div className="modal-body">
              <textarea
                placeholder="Escriba si desea algo en específico- Ej: Utilizar poca azucar."
                className="form-control"
                id="descripcionPedido"
                rows="3"
                value={descripcionPedido}
                onChange={(e) => setDescripcionPedido(e.target.value)}
              ></textarea>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-all" data-bs-dismiss="modal" onClick={() => setModalVisible(false)}>x Cancelar</button>
              <button type="button" className="btn btn-oscuro" data-bs-dismiss="modal" onClick={guardarPreferencias}>+ Guardar</button>
            </div>
          </div>
        </div>
      </div>
      {modalVisible && <div className="modal-backdrop fade show"></div>}
    </>
  );
};

export default CreatePedido;
