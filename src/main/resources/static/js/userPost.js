$(document).ready(function () {
    $('#user-userId-input').empty();
    $('#user-title-input').empty();
    $('#user-content-textarea').empty();
    $('#user-ModifyDate-input').empty();

    $('#user-userId-input').attr("readonly", true);
    $('#user-title-input').attr("readonly", true);
    $('#user-content-textarea').attr("readonly", true);
    $('#user-ModifyDate-input').attr("readonly", true);

    let loc = location.href;
    let url = new URL(loc);
    let urlParams = url.searchParams;
    let id = urlParams.get('postId');
    showUserPost(id);
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function showUserPost(postId) {
    let id = postId;
    $.ajax({
        type: "GET",
        url: "/posts/" + id,
        success: function (response) {
            let postDto = response;
            putValues(postDto);
        }
    });
}

function putValues(postDto) {
    $('#user-userId-input').val(postDto.userId);
    $('#user-title-input').val(postDto.title);
    $('#user-content-textarea').val(postDto.content);
    $('#user-ModifyDate-input').val(postDto.modifiedAt);
}