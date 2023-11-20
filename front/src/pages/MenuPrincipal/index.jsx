const MenuPrincipal = () => {
  return (
<div className="contenido">
  <h1>Menú Administrador</h1>
  <div className="opciones menuAdmin">
    <div className="btn_opciones">
      <a href="ventas/visualizarVenta">
        <img src="assets/icons/ventas.png" alt />
      </a>
      <h2>Ventas</h2>
    </div>
    <div className="btn_opciones">
      <a href="inventario/visualizarInventario">
        <img src="assets/icons/Inventario.png" alt />
      </a>
      <h2>Inventario</h2>
    </div>
    <div className="btn_opciones">
      <a href="ordenes/visualizar">
        <img src="assets/icons/Proveedores.png" alt />
      </a>
      <h2>Proveedores</h2>
    </div>
    <div className="btn_opciones">
      <a href="pedidos">
        <img src="assets/icons/Pedidos.png" alt />
      </a>
      <h2>Pedidos</h2>
    </div>
    <div className="btn_opciones">
      <a href="#">
        <img src="assets/icons/Configuracion.png" alt />
      </a>
      <h2>Configuración</h2>
    </div>
  </div>
</div>

  )
}

export default MenuPrincipal