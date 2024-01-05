import "./NavBar.css";

const NavBar = () => {
    const hola = "hola";
    return (
        <nav className="menuSuperior">
  <div className="logosMenu">
    <div>
      <label htmlFor="menuHam">
        <img className="icon" src='/assets/icons/Menu Hamburguesa.png'/>
      </label>
      <input type="checkbox" id="menuHam" />
      <div className="menuLateral">
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoVentas.png' alt="icono" />
          <a href="../ventas/visualizarVenta">Ventas</a>
        </div>
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoInventario.png' alt="icono" />
          <a href="../inventario/visualizarInventario">Inventario</a>
        </div>
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoProveedores.png' alt="icono" />
          <a href="../ordenes/visualizar">Proveedores</a>
        </div>
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoPedidos.png' alt="icono" />
          <a href="../pedidos/visualizar">Pedidos</a>
        </div>
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoUsuarios.png' alt="icono" />
          <a href="../usuarios/login">Usuarios</a>
        </div>
        <div className="menuLateral__Opcion">
          <img src='/assets/icons/menuLateral/LogoEstadisticas.png' alt="icono" />
          <a href="#">Estadísticas</a>
        </div>
      </div>
    </div>
    {
        // Aca debo saber en que ruta estoy para mostrar el logo
        <a href="/">
            <img className="icon" src='/assets/icons/LogoCasa.png'/>
        </a>
    }
    
  </div>
  <div className="menu-logo">
    <img src='/assets/img/logoClaro.png'/>
  </div>
  <div className="dropdown">
    <button className="dropdown-toggle menu-user" type="button" data-bs-toggle="dropdown" aria-expanded="false">
      <img className="icon" src='/assets/icons/Logo Usuario.png'/>
      {'{'}{'{'} Auth::user()-&gt;nombre_Usuario {'}'}{'}'}
    </button>
    <ul className="dropdown-menu user-dropdown">
      <li>
        <a className="dropdown-item" href="#">
          <img src='/assets/icons/LogoUserWhite.png'/>
          Perfil de Usuario
        </a>
      </li>
      <li>
        <a className="dropdown-item" href="{{ route('logout') }}">
          <img src='/assets/icons/LogoOffWhite.png'/>
          Cerrar Sesión
        </a>
        <form id="logout-form" action="" method="POST" className="d-none">
        </form>
      </li>
    </ul>
  </div>
</nav>

    );
}

export default NavBar;