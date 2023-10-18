import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import Landing from './pages/Landing';

function App() {
  return (
    <BrowserRouter>
    <NavBar/>
      <Routes>
        <Route path='/' element={<div>Soy el contenido</div>}/>
        <Route path='/Landing' element={<Landing/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
