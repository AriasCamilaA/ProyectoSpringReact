import "./Footer.css";

const Footer = () =>{
    return (
        <footer>
            <div id="contactanos" className="container">
    <div className="datos">
      <img src='assets/img/logoClaro.png' alt="logo" />
      <ul>
        <li>Contacto : 3158779538</li>
        <li>Dirección: Cra. 141b # 144-63</li>
        <li>E-mail: isabelcastilla@gmail.com</li>
        <li>Creado  por PigeonSoft | 2023</li>
      </ul>
    </div>
    <div className="map">
      <h2>Visitanos</h2>
      <iframe className="mapCatilla" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3976.0979719242873!2d-74.11667598590977!3d4.753003942526904!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f847b7ad1f1d7%3A0x985847d5e9939f43!2sCra.%20141b%20%23144-63%2C%20Suba%2C%20Bogot%C3%A1%2C%20Cundinamarca!5e0!3m2!1ses!2sco!4v1677128620738!5m2!1ses!2sco" width="100%" height={200} style={{border: 0}} allowFullScreen loading="lazy" referrerPolicy="no-referrer-when-downgrade" />
    </div>
        </div></footer>
    );
}

export default Footer;