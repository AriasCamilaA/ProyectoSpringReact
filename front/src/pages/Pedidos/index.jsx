import React, { useEffect, useState } from 'react';
import apiService from '../../services';
import "../../css/botones.css";
import "../../css/tab_tabla.css";
import "../../css/tablas.css";
import CreatePedido from './components/CreatePedido';
import { showAlert } from '../../utilities';

const Pedidos = () => {
    const [pedidos, setPedidos] = useState([]);
    const [pedidosFinalizados, setPedidosFinalizados] = useState([]);
    const [pedidosNoFinalizados, setPedidosNoFinalizados] = useState([]);
    const [estadosPedidos, setEstadosPedidos] = useState([]);
    const [tabActual, setTabActual] = useState('Pendientes');
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedEstado, setSelectedEstado] = useState(null);
    const estados = [
        { label: 'Por Aprobar', value: 'porAprobar' },
        { label: 'Aprobado', value: 'aprobado' },
        { label: 'Preparándose', value: 'preparandose' },
        { label: 'Para Recoger', value: 'paraRecoger' },
        { label: 'Cancelado', value: 'cancelados' },
        { label: 'Aceptar Cambios', value: 'aceptarCambios' },
        { label: 'Finalizados', value: 'finalizados' },
    ];

    const [modalVisible, setModalVisible] = useState(false);

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
            .catch((error) => {
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

    const cambiarTab = (tab) => {
        setTabActual(tab);
    };

    const handleEstadoClick = (estado) => {
        setSelectedEstado(estado);
    };

    function tabTabla(tabName) {
        const tabContents = document.getElementsByClassName("tab_content");
        for (let i = 0; i < tabContents.length; i++) {
            tabContents[i].style.display = "none";
        }

        const tablinks = document.getElementsByClassName("tablink");
        for (let i = 0; i < tablinks.length; i++) {
            tablinks[i].classList.remove("bg-oscuro");
        }

        const selectedTab = document.getElementById(tabName);
        if (selectedTab) {
            selectedTab.style.display = "block";
        }

        const clickedTablink = document.getElementById(`tablink-${tabName}`);
        if (clickedTablink) {
            clickedTablink.classList.add("bg-oscuro");
        }
    }

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
                    <div>
                        <img src="/assets/icons/lupa.png" />
                        <input type="text" onChange={(e) => setSearchTerm(e.target.value)} id="searchTerm" />
                        <img
                            src="/assets/icons/agregar.png"
                            data-bs-toggle="modal" data-bs-target="#create"
                        />    
                    </div>
                    <div className="filtros__fecha">
                        <input type="date" />
                        <input type="date" />
                    </div>
                    <img src="/assets/icons/excel.png" />
                    <a href="#">
                        PDF
                    </a>
                </div>
                <div className="tablaConTab">
                    <div>
                        <button
                            id="tablink-Pendientes"
                            className={`tablink ${tabActual === 'Pendientes' ? 'bg-oscuro' : ''}`}
                            onClick={() => { cambiarTab('Pendientes'); tabTabla('Pendientes'); }}
                        >
                            Pendientes
                        </button>
                        <button
                            id="tablink-Finalizados"
                            className={`tablink ${tabActual === 'Finalizados' ? 'bg-oscuro' : ''}`}
                            onClick={() => { cambiarTab('Finalizados'); tabTabla('Finalizados'); }}
                        >
                            Finalizados
                        </button>
                    </div>
                    <div id="Pendientes" className="tab_content">
                        <div className="tabla">
                            <table className="table table-hover" id="datos">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Descripción</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Documento</th>
                                        <th scope="col">Celular</th>
                                        <th scope="col">Cliente</th>
                                        <th className="tabla__estado" scope="col">Estado</th>
                                        <th className="tabla__opcion" scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {pedidosNoFinalizados
                                        .filter(pedido => pedido.usuario.nombreUsuario.toLowerCase().includes(searchTerm) || pedido.usuario.apellidoUsuario.toLowerCase().includes(searchTerm) || pedido.usuario.noDocumentoUsuario.toString().toLowerCase().includes(searchTerm))
                                        .map((pedido) => (
                                            <tr key={pedido.idPedido}>
                                                <th>{pedido.idPedido}</th>
                                                <td>{pedido.descripcionPedido}</td>
                                                <td>{pedido.fechaPedido}</td>
                                                <td>{pedido.usuario.noDocumentoUsuario}</td>
                                                <td>{pedido.usuario.celularUsuario}</td>
                                                <td>{pedido.usuario.nombreUsuario} {pedido.usuario.apellidoUsuario}</td>
                                                <td className="tabla__estado">
                                                    <label className={`py-1 px-2 rounded border-radius-5 lbl_Estado btn-${estados.find(estado => estado.label === pedido.estadoPedido.nombreEstado)?.value}`}>
                                                        {pedido.estadoPedido.nombreEstado}
                                                    </label>
                                                </td>
                                                <td className="tabla__opcion">
                                                    <a href="./verPedido">
                                                        <img src="/assets/icons/visualizar.png" alt="Visualizar" />
                                                    </a>
                                                </td>
                                            </tr>
                                        ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="Finalizados" className="tab_content" style={{ display: 'none' }}>
                        <div className="tabla">
                            <table className="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Descripción</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Documento</th>
                                        <th scope="col">Celular</th>
                                        <th scope="col">Cliente</th>
                                        <th className="tabla__estado" scope="col">Estado</th>
                                        <th className="tabla__opcion" scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {pedidosFinalizados
                                        .filter(pedido => pedido.descripcionPedido.toLowerCase().includes(searchTerm))
                                        .map((pedido) => (
                                            <tr key={pedido.idPedido}>
                                                <th>{pedido.idPedido}</th>
                                                <td>{pedido.descripcionPedido}</td>
                                                <td>{pedido.fechaPedido}</td>
                                                <td>{pedido.usuario.noDocumentoUsuario}</td>
                                                <td>{pedido.usuario.celularUsuario}</td>
                                                <td>{pedido.usuario.nombreUsuario} {pedido.usuario.apellidoUsuario}</td>
                                                <td className="tabla__estado">
                                                    <label className={`py-1 px-2 rounded border-radius-5 lbl_Estado btn-${estados.find(estado => estado.label === pedido.estadoPedido.nombreEstado)?.value}`}>
                                                        {pedido.estadoPedido.nombreEstado}
                                                    </label>
                                                </td>
                                                <td className="tabla__opcion">
                                                    <a href="./verPedido">
                                                        <img src="/assets/icons/visualizar.png" alt="Visualizar" />
                                                    </a>
                                                </td>
                                            </tr>
                                        ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
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
                            <CreatePedido/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>
    );
};

export default Pedidos;
