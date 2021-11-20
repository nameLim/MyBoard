$(document).ready(function () {
    showPostList();
})


function addHTML(postDto) {
    return `<tr class="alert" role="alert" onclick="location.href='userPost.html?postId=${postDto.id}'">
                <th scope="row">${postDto.id}</th>
                <td>${postDto.title}</td>
                <td>${postDto.userId}</td>
                <td>${postDto.modifiedAt}</td>
                <td>
                    <a href="#" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true"><i class="fa fa-close"></i></span>
                    </a>
                </td>
            </tr>`;
}

// function addPost() {
//     let postDto = {
//             userId: $('#userId-input').val(),
//             title : $('#title-input').val(),
//             content: $('#content-textarea').val()
//         }
//
//     $.ajax({
//         type:"POST",
//         url:"/posts",
//         data:JSON.stringify(postDto),
//         contentType: "application/json",
//         success: function(response){
//             // window.location.href="/index.html";
//             window.location.href="/";
//         }
//     });
// }

function showPostList() {
    $.ajax({
        type: "GET",
        url: "/posts",
        success: function (response) {
            $('#post-table-body').empty();
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let tempHtml = addHTML(post);
                $('#post-table-body').append(tempHtml);
            }
        }
    });
}