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