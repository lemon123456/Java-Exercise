
$(function(){
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
   })
});


$(function () {
    $('#insertButton').on('click', function () {
        $('#insertCourseForm').toggle();
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

function updateCourse(){
    var name = $('#nameInput').val();
    if(name == ""){
        alert("Name can not be set null!");
        return false;
    }

    var form = $('#updateCourseForm');
    var id = $('#idInput').val();
    form.submit(function (e) {
        e.preventDefault();
        $.ajax({
            url: '/web/course/' + id,
            type:'PUT',
            dataType: 'text',
            data: form.serialize(),
            success: function(result){
                alert("更新成功");
                var tr = '#tr'+result.id;
                $(tr).empty();
                $(tr).append(result.courseName);
                $(tr).append(result.description);
            },
            error: function(){
                alert("更新失败");
                return;
            }
        });
    })
}

$(function () {

    $('.updateButton').on('click', function () {
        var id = $(this).data('course-id');
        var name = $(this).data('course-name');
        var description = $(this).data('course-description');

        $('input[name=id]').val(id);
        $('input[name=courseName]').val(name);
        $('input[name=description]').val(description);

        $('#updateCourseForm').toggle();
    });
});

