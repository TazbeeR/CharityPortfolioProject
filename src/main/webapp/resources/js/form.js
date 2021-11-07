function finalizingForm() {

    let quantityOfBags = document.getElementById("quantityOfBags");
    if (quantityOfBags.value === 1) {
        document.getElementById("finalQuantity").innerText = quantityOfBags.value + ' worek darów';
    }else if (quantityOfBags.value > 1 && quantityOfBags < 5){
        document.getElementById("finalQuantity").innerText = quantityOfBags.value + ' worki darów';
    } else {
        document.getElementById("finalQuantity").innerText = quantityOfBags.value + ' worków darów';
    }


    let street = document.getElementById("formStreet");
    document.getElementById("liStreet").innerText = street.value;

}