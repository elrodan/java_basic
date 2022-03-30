$(function(){

    const appendTodo = function(data){
        var todoCode = '<a href="#" class="todo-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#todo-list')
            .append('<div>' + todoCode + '</div>');
    };

    //Show adding todo form
    $('#show-add-todo-form').click(function(){
        $('#todo-form').css('display', 'flex');
    });

    //Closing adding todo form
    $('#todo-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting todo
    $(document).on('click', '.todo-link', function(){
        var link = $(this);
        var todoId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/todo/' + todoId,
            success: function(response)
            {
                var code = '<span>Описание дела:' + response.description + '</span>';
                link.parent().append(code);
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

    //Adding book
    $('#save-todo').click(function()
    {
        var data = {
            "name" : $('#todo-form form').find('#name').val(),
            "description" : $('#todo-form form').find('#description').val()
        };
        console.log(data);
        $.ajax({
            method: "POST",
            url: '/todo/',
            contentType: 'application/json',
            data: data,
            dataType: 'json',
            success: function(response)
            {
                $('#todo-form').css('display', 'none');
                var todo = {};
                todo.id = response;
                var dataArray = $('#todo-form form').serializeArray();
                for(i in dataArray) {
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTodo(todo);
            }
        });
        return false;
    });

});