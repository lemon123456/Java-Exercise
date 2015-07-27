$(function () {
    $('#insertButton').on('click', function () {
        $('#insertCourseForm').toggle();
    });


    $('.updateButton').on('click', function () {
        var id = $(this).data('course-id');
        var name = $(this).data('course-name');
        var description = $(this).data('course-description');

        $('input[name=id]').val(id);
        $('input[name=courseName]').val(name);
        $('input[name=description]').val(description);
        $('#updateCourseForm').toggle();
    });

    var course;
    $('.deleteButton').on('click', function(){
        if(confirm("确定要删除吗？")) {
            course = this;
            var id = course.closest('td').id;
            $.ajax({
                url: '/web/course/' + id,
                type: 'DELETE',
                dataType: 'text',
                success: function () {
                    course.closest('tr').remove();
                }
            })
        }
    });


    $('#updateCourseForm').submit(function () {
        var name = $('#nameInput').val();
        if(name == ""){
            alert("Name can not be set null!");
            return false;
        }

        var id = $('#idInput').val();
        var form = $('#updateCourseForm');
        $.ajax({
            url: '/web/course/',
            type: 'PUT',
            dataType: 'json',
            data: form.serialize(),
            success: function(result){
                console.log(result);
                alert("更新成功");
                var tr = '#tr'+result.id;
                $(tr).text('Hello');
                $(tr).empty();
                $(tr).append(result.courseName);
                $(tr).append(result.description);
            }
        });
    });
});

function insertCourse() {
    var name = $('#nameInsert').val();
    if(name == ""){
        alert("Name can not be set null!");
        return;
    }
    var form = $('#insertCourseForm');
    $.ajax({
        url: '/web/course',
        type: 'POST',
        dataType: 'text',
        data: form.serialize(),
        success: function () {
            window.location.reload();
        }
    })
}


//$(function(){

    //$('#submitInput').on('click',function(){
    //    var name = $('#nameInput').val();
    //    if(name == ""){
    //        alert("Name can not be set null!");
    //        return false;
    //    }
    //
    //    var id = $('#idInput').val();
    //    var form = $('#updateCourseForm');
    //    console.log(id+"2@*@@@");
    //    $.ajax({
    //        url: '/web/course/' + id,
    //        type:'PUT',
    //        dataType: 'json',
    //        data: form.serialize(),
    //        success: function(result){
    //            console.log(result);
    //            alert("更新成功");
    //            var tr = '#tr'+result.id;
    //            $(tr).empty();
    //            $(tr).append(result.courseName);
    //            $(tr).append(result.description);
    //        }
    //    });
    //})
//});

//function updateCourse(){
//    var name = $('#nameInput').val();
//    if(name == ""){
//        alert("Name can not be set null!");
//        return false;
//    }
//
//    var form = $('#updateCourseForm');
//    var id = $('#idInput').val();
//    console.log(id+"2@*@@@");
//    $.ajax({
//        url: '/web/course/' + id,
//        type:'PUT',
//        dataType: 'json',
//        data: form.serialize(),
//        success: function(result){
//            console.log(result);
//            alert("更新成功");
//            var tr = '#tr'+result.id;
//            $(tr).empty();
//            $(tr).append(result.courseName);
//            $(tr).append(result.description);
//        }
//    });
//}



