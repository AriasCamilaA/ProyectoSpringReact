import { useState } from "react";
import { formatearFecha } from "../../../../utilities";

const TablePedidos = ({pedidosNoFinalizados, pedidosFinalizados, searchTerm, estados}) => {
    const [tabActual, setTabActual] = useState('Pendientes');

    const cambiarTab = (tab) => {
        setTabActual(tab);
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
                    <table className="table table-hover sticky-header" id="datos">
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
                                        <td>{formatearFecha(pedido.fechaPedido)}</td>
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
                                .filter(pedido => pedido.usuario.nombreUsuario.toLowerCase().includes(searchTerm) || pedido.usuario.apellidoUsuario.toLowerCase().includes(searchTerm) || pedido.usuario.noDocumentoUsuario.toString().toLowerCase().includes(searchTerm))
                                .map((pedido) => (
                                    <tr key={pedido.idPedido}>
                                        <th>{pedido.idPedido}</th>
                                        <td>{pedido.descripcionPedido}</td>
                                        <td>{formatearFecha(pedido.fechaPedido)}</td>
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
    )
}

export default TablePedidos