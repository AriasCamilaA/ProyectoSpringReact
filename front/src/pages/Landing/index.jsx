import Footer from "./components/Footer";
import NavBar from "./components/Navbar";
import "./Landing.css";

const Landing = () => {
    return (
        <>
            <NavBar/>
            <div>
            <section id="banner">
                <div id="carouselExampleIndicators" className="carousel slide">
                <div className="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={0} className="active" aria-current="true" aria-label="Slide 1" />
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={1} aria-label="Slide 2" />
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={2} aria-label="Slide 3" />
                </div>
                <div className="carousel-inner">
                    <div className="carousel-item active">
                    <div className="carrusel">
                        <div>
                        <h1>producto 1</h1>
                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus laudantium
                            optio, odit porro aliquid quasi inventore quia quo neque officiis, quisquam incidunt
                            consequuntur impedit distinctio libero. Debitis aut quasi rerum.</p>
                        </div>
                        <img src='assets/img/p2.jpeg' className="d-block w-100" />
                    </div>
                    </div>
                    <div className="carousel-item">
                    <div className="carrusel">
                        <div>
                        <h1>producto 2</h1>
                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus laudantium
                            optio, odit porro aliquid quasi inventore quia quo neque officiis, quisquam incidunt
                            consequuntur impedit distinctio libero. Debitis aut quasi rerum.</p>
                        </div>
                        <img src='assets/img/p3.jpeg' className="d-block w-100" />
                    </div>
                    </div>
                    <div className="carousel-item">
                    <div className="carrusel">
                        <div>
                        <h1>producto 3</h1>
                        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus laudantium
                            optio, odit porro aliquid quasi inventore quia quo neque officiis, quisquam incidunt
                            consequuntur impedit distinctio libero. Debitis aut quasi rerum.</p>
                        </div>
                        <img src='assets/img/p4.jpeg' className="d-block w-100" />
                    </div>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true" />
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true" />
                    <span className="visually-hidden">Next</span>
                </button>
                </div>
            </section>
            <img src='assets/img/separador.png' alt className="separador" />
            <section id="quienes_somos" className="quienes_somos container ">
                <h1>Quíenes somos</h1>
                <div className="row contenido">
                <div className="col">
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Accusantium, officiis, assumenda eos sequi
                    error ipsam recusandae delectus et commodi amet culpa voluptatem a. Id aliquam aperiam aspernatur
                    excepturi omnis impedit?</p>
                </div>
                <div className="accordion accordion-flush col" id="accordionFlushExample">
                    <div className="accordion-item">
                    <h2 className="accordion-header" id="flush-headingOne">
                        <button className="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        Misión
                        </button>
                    </h2>
                    <div id="flush-collapseOne" className="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                        <div className="accordion-body">Placeholder content for this accordion, which is intended to
                        demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion
                        body.</div>
                    </div>
                    </div>
                    <div className="accordion-item">
                    <h2 className="accordion-header" id="flush-headingTwo">
                        <button className="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        Visión
                        </button>
                    </h2>
                    <div id="flush-collapseTwo" className="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                        <div className="accordion-body">Placeholder content for this accordion, which is intended to
                        demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion
                        body. Let's imagine this being filled with some actual content.</div>
                    </div>
                    </div>
                </div>
                </div>
            </section>
            <section id="especialidades" className="especialidades container">
                <div className="separador" />
                <h1>Nuestras Especialidades</h1>
                <div>
                <div>
                    <img src='assets/icons/cheesecake.png' alt="cheese_cake" />
                    <p>CHEESECAKE</p>
                </div>
                <div>
                    <img src='assets/icons/mantecada.png' alt="mantecada" />
                    <p>MANTECADA</p>
                </div>
                <div>
                    <img src='assets/icons/helado.png' alt="helado" />
                    <p>HELADO</p>
                </div>
                <div>
                    <img src='assets/icons/oblea.png' alt="oblea" />
                    <p>OBLEA</p>
                </div>
                <div>
                    <img src='assets/icons/waffle.png' alt="waffle" />
                    <p>WAFFLE</p>
                </div>
                </div>
            </section>
            <img src='assets/img/separador.png' alt className="separador" />
            <section id="galeria" className="galeria">
                <div className="separador" />
                <div className="container">
                <h1>Galería</h1>
                <div className="imgs_galeria">
                    <img src='assets/img/galeria 1.png' alt="galeria_1" />
                    <img src='assets/img/galeria 2.png' alt="galeria_2" />
                    <img src='assets/img/galeria 1.png' alt="galeria_1" />
                    <img src='assets/img/galeria 2.png' alt="galeria_2" />
                    <img src='assets/img/galeria 1.png' alt="galeria_1" />
                    <img src='assets/img/galeria 2.png' alt="galeria_2" />
                </div>
                </div>
            </section>
            <div className="separador" />
            </div>
            <Footer/>
        </>
    );
}

export default Landing;