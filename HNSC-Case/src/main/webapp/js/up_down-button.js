//
// function plus(){
//     let a = document.getElementById("number").value;
//     a++;
//     document.getElementById("number").value = a;
// }
// function minor(){
//     let a = document.getElementById("number").value;
//      a--;
//      a = a <=0 ? 1 : a;
//         document.getElementById("number").value = a;
//
// }
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll('.btn-plus').forEach(function (el) {
        el.addEventListener("click", function () {
            let a = el.previousElementSibling.value;
            a++;
            el.previousElementSibling.value = a;
        })
    });
    document.querySelectorAll('.btn-minus').forEach(function (el) {
        el.addEventListener("click", function () {
            let a = el.nextElementSibling.value;
            a--;
            a = a <= 0 ? 1 : a;
            el.nextElementSibling.value = a;
        })
    });
});

