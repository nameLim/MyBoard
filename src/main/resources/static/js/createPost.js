$(document).ready(function () {
    $('#userId-input').empty();
    $('#title-input').empty();
    $('#content-textarea').empty();
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// function showUserPost(postDto) {
//     let id = postDto.id;
//     $.ajax({
//         type: "GET",
//         url: "/posts/"+id,
//         success: function (response){
//             $('#post-table-body').empty();
//             for(let i=0; i<response.length; i++){
//                 let post = response[i];
//                 let tempHtml = addHTML(post);
//                 $('#post-table-body').append(tempHtml);
//             }
//         }
//     });
// }

function addPost() {

    let postDto = {
        userId: $('#userId-input').val(),
        title: $('#title-input').val(),
        content: $('#content-textarea').val()
    }

    $.ajax({
        type: "POST",
        url: "/posts",
        data: JSON.stringify(postDto),
        contentType: "application/json",
        success: function (response) {
            // window.location.href="/index.html";
            window.location.href = "/";
        }
    });
}
