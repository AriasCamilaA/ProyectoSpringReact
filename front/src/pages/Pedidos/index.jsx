import React, { useEffect, useState } from 'react';
import apiService from '../../services';
import { showAlert } from '../../utilities';
import CreatePedido from './components/CreatePedido';
import TablePedidos from './components/TablePedidos';
import "../../css/tab_tabla.css";
import "../../css/tablas.css";
import "../../css/filtros.css";
import "./Pedidos.css"
import "../../css/botones.css";

const Pedidos = () => {
    const [pedidos, setPedidos] = useState([]);
    const [pedidosFinalizados, setPedidosFinalizados] = useState([]);
    const [pedidosNoFinalizados, setPedidosNoFinalizados] = useState([]);
    const [estadosPedidos, setEstadosPedidos] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedEstado, setSelectedEstado] = useState(null);
    const [fechaInicio, setFechaInicio] = useState("");
    const [fechaFin, setFechaFin] = useState("");

    const estados = [
        { label: 'Por Aprobar', value: 'porAprobar' },
        { label: 'Aprobado', value: 'aprobado' },
        { label: 'Preparándose', value: 'preparandose' },
        { label: 'Para Recoger', value: 'paraRecoger' },
        { label: 'Cancelado', value: 'cancelados' },
        { label: 'Aceptar Cambios', value: 'aceptarCambios' },
        { label: 'Finalizados', value: 'finalizados' },
    ];

    useEffect(() => {
        // Obtenemos los pedidos
        apiService.getPedidos()
            .then((response) => {
                setPedidos(response);
            })
            .catch(() => {
                showAlert("error", 'Conexión Fallida', "No se pudieron cargar correctamente los pedidos");
            });

        // Obtenemos los estados de los pedidos
        apiService.getEstados()
            .then((response) => {
                setEstadosPedidos(response);
            })
            .catch(() => {
                showAlert("error", 'Conexión Fallida', "No se pudieron cargar correctamente los estados de los pedidos");
            });

    }, []);

    useEffect(() => {     
        setPedidosFinalizados(pedidos.filter(pedido => pedido.estadoPedido.nombreEstado === 'Finalizados' || pedido.estadoPedido.nombreEstado === 'Cancelado'));
        // Filtra los pedidos según el estado seleccionado
        if (selectedEstado) {
            setPedidosNoFinalizados(pedidos.filter(pedido => pedido.estadoPedido.nombreEstado === selectedEstado));
        } else {
            setPedidosNoFinalizados(pedidos.filter(pedido => pedido.estadoPedido.nombreEstado !== 'Finalizados' && pedido.estadoPedido.nombreEstado !== 'Cancelado'));
        }
    }, [selectedEstado, pedidos]);

    const handleEstadoClick = (estado) => {
        setSelectedEstado(estado);
    };

    const limpiarFiltros = () => {
        setSearchTerm("");
        setFechaInicio("");
        setFechaFin("");
    }

    const actualizarListaPedidos = async () => {
        try {
          const nuevosPedidos = await apiService.getPedidos();
          setPedidos(nuevosPedidos);
        } catch (error) {
          console.error("Error al actualizar la lista de pedidos:", error);
        }
      };


    return (
        <>
            <div className="contenido">
                <h1>Pedidos</h1>
                <div className="opciones">
                    <div>
                        <input
                            type="radio"
                            name="rd_Estado"
                            id={`rd_btn-all`}
                            className={`btn-all`}
                            onClick={() => handleEstadoClick("")}
                        />
                        <label htmlFor={`rd_btn-all`} className={`lbl_Estado btn-all`}>
                            Todos
                        </label>
                    </div>
                    {estadosPedidos.map((estadoPedidos) => {
                        const estadoCorrespondiente = estados.find(estado => estado.label === estadoPedidos.nombreEstado);

                        if (estadoCorrespondiente && estadoPedidos.nombreEstado !== "Finalizados" && estadoPedidos.nombreEstado !== "Cancelado") {
                            const { label, value } = estadoCorrespondiente;

                            return (
                                <div key={value}>
                                    <input
                                        type="radio"
                                        name="rd_Estado"
                                        id={`rd_btn-${value}`}
                                        className={`btn-${value}`}
                                        onClick={() => handleEstadoClick(estadoPedidos.nombreEstado)}
                                    />
                                    <label htmlFor={`rd_btn-${value}`} className={`lbl_Estado btn-${value}`}>
                                        {label}
                                    </label>
                                </div>
                            );
                        }

                        return null;
                    })}
                </div>
                <div className="filtros">
                    <div className='filtros__div1'>
                        <div className='inputSearch'>
                            <img src="/assets/icons/lupa.png" />
                            <input type="text" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} id="searchTerm" placeholder='Nombre o #Documento' />
                        </div>
                        <div className="filtros__fecha">
                            <input type="date" value={fechaInicio} onChange={(e) => setFechaInicio(e.target.value)} id="fechaInicio"/>
                            <input type="date" value={fechaFin} onChange={(e) => setFechaFin(e.target.value)} id="fechaFin"/>
                        </div>
                        <p className='btn btn-oscuro mb-0 py-1 px-2' onClick={()=>limpiarFiltros()}>x</p>
                    </div>
                    <div className='flitros__opciones d-flex'>
                        <p className='btn btn-excel'>Excel</p>
                        <p className='btn btn-pdf'>PDF</p>
                        <p className='btn btn-oscuro' data-bs-toggle="modal" data-bs-target="#create">
                            <strong className='me-1'>+</strong>
                            Agregar Pedido
                        </p> 
                    </div>
                </div>
                <TablePedidos 
                    pedidosNoFinalizados={pedidosNoFinalizados} 
                    pedidosFinalizados={pedidosFinalizados}
                    searchTerm={searchTerm}
                    estados={estados}
                    fechaInicio={fechaInicio}
                    fechaFin={fechaFin}
                />
            </div>
            
            <div className="modal fade" id="create" tabIndex={-1} role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
                <div className="modal-dialog modal-xl" role="document">
                    <div className="modal-content">
                        <div className="modal-header d-flex align-items-start">
                            <h5 className="modal-title" id="modalTitleId">Nuevo Pedido</h5>
                            <button type="button" className="btn-close text-light p-0" data-bs-dismiss="modal" aria-label="Close">
                                <p style={{fontFamily: "arial"}}>x</p>
                            </button>
                        </div>
                        <div className="modal-body">
                            <div className="container-fluid">
                            <CreatePedido actualizarListaPedidos={actualizarListaPedidos}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>
    );
};

export default Pedidos;
