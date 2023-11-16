import "../../../../css/createPedidoVenta.css"

const CreatePedido = () => {
  return (
    <div className="modal-body">
    <div class="catalogo">
                  {/* @foreach($productos as $producto) */}
                  <div class="card" style={{width: "18rem"}}>
                      {/* {{-- <img src="{{asset("assets/img/galeria 1.png")}}" class="card-img-top" alt="..."> --}} */}
                      <div class="card-body">
                          <h5 class="card-title nombre_Producto">nombre_Producto</h5>
                          <p class="card-title precio_Producto">$ 100.000</p>
                          <a href="#" class="btn agregar-producto" data-producto-id="{{$producto->id_Producto}}">Agregar</a>
                      </div>
                  </div>
                {/* //   @endforeach */}
                </div>
                <div class="carrito">
                  <h2 class="titulo">
                    Carrito
                  </h2>
                  <div class="carrito__productos">
                    
                  </div>
                  <div class="carrito__footer">
                    <h2>Total</h2>
                    <p id="total-precio">$0</p> 
                </div>                
                  <button class="btn" id="crear-pedido">Crear Pedido</button>
                </div>
    </div>
  )
}

export default CreatePedido