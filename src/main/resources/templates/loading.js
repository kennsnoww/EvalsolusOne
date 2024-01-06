// loading.js
document.addEventListener('DOMContentLoaded', function () {
    // Afficher le spinner immédiatement lors du chargement de la page
    showSpinner();

    // Masquer le spinner après 2 secondes (2000 millisecondes)
    setTimeout(function () {
        hideSpinner();
    }, 20000);
});

function showSpinner() {
    document.getElementById('spinner-container').style.display = 'block';
}

function hideSpinner() {
    document.getElementById('spinner-container').style.display = 'none';
}
