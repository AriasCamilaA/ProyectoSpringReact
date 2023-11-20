import { useEffect, useState } from "react";
import { CiCalendar, CiCircleInfo, CiMail, CiPhone, CiUser } from "react-icons/ci";
import apiService from "../../../../services";
import { formatearFecha, formatearFechaParaInputDate, showAlert } from "../../../../utilities";

const UpdatePedido = ({pedidoById}) => {
    const [pedido,setPedido] = useState();

    useEffect(() => {
        // Obtenemos el pedido
        apiService.getPedidosById(pedidoById)
            .then((response) => {
                setPedido(response);
                console.log(response); // Asegúrate de que aquí obtienes los datos correctamente
            })
            .catch(() => {
                showAlert("error", 'Conexión Fallida', "No se pudieron cargar correctamente el pedido");
            });
    }, [pedidoById]);

  return (
    <>
        {pedido && (
            <div className="d-flex flex-column">
                
                <h4 className="color-oscuro fw-bold m-0 me-2"> Datos de Usuario:</h4>
                <span className="fw-light mb-2">(<CiCircleInfo /> Si desea cambiar estos datos dirijase a su perfil)</span>
                <div className="input-group mb-3">
                    <span className="input-group-text"><CiUser/></span>
                    <input type="text" className="form-control" placeholder="Nombre" aria-label="Username" value={`${pedido.usuario.nombreUsuario} ${pedido.usuario.apellidoUsuario}`} disabled/>
                    <span className="input-group-text"><CiMail/></span>
                    <input type="text" className="form-control" placeholder="Correo" aria-label="Server" value={pedido.usuario.email} disabled/>
                    <span className="input-group-text"><CiPhone/></span>
                    <input type="text" className="form-control" placeholder="Teléfono" aria-label="Server" value={pedido.usuario.celularUsuario} disabled/>
                </div>

                <h4 className="color-oscuro fw-bold m-0 me-2">Datos de Pedido:</h4>
                <span className="fw-light mb-2">(<CiCircleInfo /> Tenga en cuenta que estos cambios deben ser aprobados para actualización del pedido)</span>

                <div className="input-group mb-3">
                    <span className="input-group-text"><CiCalendar/></span>
                    <input type="date" className="form-control" placeholder="Fecha" aria-label="Username" value={formatearFechaParaInputDate(pedido.fechaPedido)}/>
                    <span className="input-group-text"><CiCircleInfo/></span>
                    <input type="text" className="form-control" placeholder="Estado" aria-label="Server" value={pedido.estadoPedido.nombreEstado}/>
                </div>

                <div className="form-floating">
                    <textarea className="form-control" placeholder="Leave a comment here" id="floatingTextarea" value={pedido.descripcionPedido}></textarea>
                    <label htmlFor="floatingTextarea">Descripción</label>
                </div>
                
            </div>
        )}
    </>
  )
}

export default UpdatePedido