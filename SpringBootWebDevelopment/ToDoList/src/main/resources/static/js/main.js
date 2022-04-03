$(function(){

    const appendTodo = function(data){
        var todoCode = '<a href="#" class="todo-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#todo-list')
            .append('<div>' + todoCode + '</div>');
    };

    $('#show-add-todo-form').click(function(){
        $('#todo-form').css('display', 'flex');
    });

    $('#todo-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    $(document).on('click', '.todo-link', function(){
        var link = $(this);
        var todoId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/todo/' + todoId,
            success: function(response)
            {
                if($('.todo-item[data-id="'+ todoId +'"').attr('connect')){
                    $('.text, item-' + todoId).remove();
                    $('.todo-item[data-id="'+ todoId +'"').removeAttr('connect')
                } else {
                    var code = '<div class="text ' + 'item-' + todoId +'">' + response.description + '</div>';
                        $('.todo-item[data-id="'+ todoId +'"').append(code);
                        $('.todo-item[data-id="'+ todoId +'"').attr('connect', 'true');
                }
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Такого дела нет!');
                }
            }
        });
        return false;
    });

    $(document).on('click', '#edit-todo', function() {
        var edit = $(this);
        var editId = edit.data('id');
        $.ajax({
           method: "GET",
           url: '/todo/' + editId,
           success: function(response)
           {
           var editForm = '<div id="get-todo-form">' +
                           '<form>' +
                               '<h2>Редактирование дела</h2>' +
                               '<input type="hidden" name="id" value="'+ editId +'">' +
                               '<label>Имя дела</label>' +
                               '<input id="name" type="text" name="name" value="'+ response.name +'">' +
                               '<label>Описание дела</label>' +
                               '<textarea id="description" rows="10" name="description" value="">'+ response.description +'</textarea>' +
                               '<hr>' +
                               '<button id="save-edited-todo" onclick="saveEditingTodo();">Сохранить</button>' +
                           '</form>' +
                       '</div>';
           $('body').append(editForm);
           }
        });
        return false;
    });

    $("#todo-form").submit(
        function(event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            var formData = {
                name : $("#name").val(),
                description : $("#description").val(),
            }

            $.ajax({
                type : "POST",
                contentType : 'application/json',
                url : '/todo/',
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                        location.reload();
                },
                error : function(e) {
                    $("#todo-form").html("Ошибка!");
                }
            });

       }

       $("body").on("click","#delete-todo",function(e){
           e.preventDefault();

           var id = $(this).data('id');
           var token = $("meta[name='csrf-token']").attr("content");

           $.ajax({
               url: "/todo/"+id,
               type: 'DELETE',
               data: id,
               success: function (){
                   $('[data-id="' + id + '"]').remove();
                   location.reload();
               },
           });

       });
       $(document).mouseup(function (e) {
           var container = $('#get-todo-form');
           if (container.has(e.target).length === 0){
               container.remove();
           }
       });

       $('#delete-all').click(function() {
           $.ajax({
               method: "DELETE",
               url: '/todo/',
               success: function()
               {
                   location.reload();
               },
           });
           return false;
       });
});

function saveEditingTodo() {
   event.preventDefault();
   ajaxPut();
}

function ajaxPut() {
   var id = $('input[name=id]').val();
   var data = $('#get-todo-form form').serialize();
   var url = '/todo/' + id;
   $.ajax({
       method: "PUT",
       url: '/todo/' + id,
       data: data,
       success: function(response)
       {
           $('#get-todo-form').css('display', 'none');
           location.reload();
       },
       error : function(e) {
           $("#get-todo-form").html("Ошибка!");
       }
   });
   return false;
}