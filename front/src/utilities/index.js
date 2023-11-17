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

