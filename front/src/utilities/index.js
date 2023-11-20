import Swal from "sweetalert2"
import withReactContent from "sweetalert2-react-content"

export function showAlert(i, title, text){
    const MySwal = withReactContent(Swal);
    MySwal.fire({
        title:title,
        text:text,
        icon:i
    });
}

export function formatNumberToCop(value) {
    // Formatear el número en formato de pesos colombianos
    const formattedValue = new Intl.NumberFormat('es-CO', {
        style: 'currency',
        currency: 'COP',
        minimumFractionDigits: 0,
        maximumFractionDigits: 0
    }).format(value);

    return formattedValue;
}

export function formatNumberToCopWithDecimal(value) {
    // Formatear el número en formato de pesos colombianos
    const formattedValue = new Intl.NumberFormat('es-CO', {
        style: 'currency',
        currency: 'COP',
        minimumFractionDigits: 2,
        maximumFractionDigits: 2
    }).format(value);

    return formattedValue;
}

export const formatearFecha = (fechaString) => {
    const fecha = new Date(fechaString);
    
    // Obtener día, mes y año
    const dia = fecha.getDate();
    const mes = fecha.toLocaleString('default', { month: 'short' }); // Obtiene el mes en formato de tres letras
    const anio = fecha.getFullYear();
    
    // Concatenar y devolver la fecha formateada
    return `${dia}/${mes}/${anio}`;
  };

export const formatearFechaParaInputDate= (fecha) => {
    // Asegúrate de que la fecha es un array con al menos tres elementos
    if (!Array.isArray(fecha) || fecha.length < 3) {
        return null; // Si la fecha no es válida, devuelve null
    }

    // Extrae los componentes de la fecha
    const [anio, mes, dia] = fecha;

    // Añade ceros a la izquierda si es necesario (para asegurar dos dígitos en mes y día)
    const mesFormateado = mes.toString().padStart(2, '0');
    const diaFormateado = dia.toString().padStart(2, '0');

    // Formatea la fecha como "YYYY-MM-DD"
    const fechaFormateada = `${anio}-${mesFormateado}-${diaFormateado}`;

    return fechaFormateada;
}
