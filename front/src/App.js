import { BrowserRouter, Routes, Route, useLocation } from 'react-router-dom';
import NavBar from './components/NavBar';
import Landing from './pages/Landing';
import MenuPrincipal from './pages/MenuPrincipal';
import Pedidos from './pages/Pedidos';

// Para reanderizar el navbar si la ruta es diferente de Landing
const NavBarWithLocation = () => {
  const location = useLocation();
  const hideNavBar = location.pathname === '/Landing';
  return (
    <>
      {!hideNavBar && <NavBar />}
    </>
  );
};

function App() {
  return (
    <BrowserRouter>
      {/* Use NavBarWithLocation instead of NavBar directly */}
      <NavBarWithLocation />
      <Routes>
        <Route exact path='/' element={<MenuPrincipal />} />
        <Route path='/Landing' element={<Landing />} />
        <Route path='/Pedidos' element={<Pedidos />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
