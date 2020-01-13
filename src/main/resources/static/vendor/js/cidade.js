function buscarCidade(){
    $('.load').show();

    $('#nomeCidade').css('border-color','');
    $('.alert').alert('close')

    var nomeCidade = $('#nomeCidade').val();
    var apiKey = 'eb8b1a9405e659b2ffc78f0a520b1a46';

    if(nomeCidade == ''){
        $('#nomeCidade').css('border-color','red');
        alerta('erro', 'Obrigatório informar a cidade!');
        $('.load').hide();
    }else{
        $.ajax({
            url: 'https://api.openweathermap.org/data/2.5/weather?q=' + nomeCidade + '&appid=' + apiKey,
            type: 'GET',
            success: function (data) {
                cadastrarCidade(data);
                $('#nomeCidade').val('');
            },
            error: function (err) {
                console.log('Erro ao buscar cidade');
                alerta('erro', 'Cidade não encontrada!');
                $('.load').hide();
            }
        });
    }
}

function cadastrarCidade(data){

    var dadosCidade = {idCidade: data.id,
                      nomeCidade: data.name,
                      siglaPais: data.sys.country};

    $.ajax({
        url: 'cidades/cadastrar',
        type: 'POST',
        data: dadosCidade,
        success: function (res) {
            alerta('sucesso', 'A cidade foi cadastrada com sucesso! Para visualizar detalhes da previsão, <a href="/previsao?idCidade='+data.id+'" class="alert-link"> clique aqui!</a></span>');

            var tb = '';
            tb += '<tr id="'+ data.id +'">';
            tb += '	    <td>' + data.name + '</td>';
            tb += '	    <td>' + data.sys.country + '</td>';
            tb += '	    <td> <a href="/previsao?idCidade='+data.id+'">Visualizar detalhes da previsão</a> </td>';
            tb += '	    <td class="text-center"> <a id="excluir" href="/" onclick="excluirCidade(event, '+ data.id +');"><i class="fa fa-lg fa-times" style="color:red"></i></a> </td>';
            tb += '</tr>';

            $('#tb_listaCidades').append(tb);
            $('.load').hide();
        },
        error: function (err) {
            if(err.status == 400){
                alerta('erro', err.responseText);
            }else{
                alerta('erro', 'Erro ao cadastrar a cidade!');
            }
            console.log('Erro ao cadastrar cidade');
            $('.load').hide();
        }
    });
}

function listarCidades(){

    $.ajax({
        url: 'cidades/listarCidades',
        type: 'POST',
        success: function (data) {
            for(var i = 0; i < data.length; i++){
                var tb = '';
                tb += '<tr id="'+data[i].idCidade+'">';
                tb += '	    <td>' + data[i].nomeCidade + '</td>';
                tb += '	    <td>' + data[i].siglaPais + '</td>';
                tb += '	    <td> <a href="/previsao?idCidade='+data[i].idCidade+'">Visualizar detalhes da previsão</a> </td>';
                tb += '	    <td class="text-center"> <a id="excluir" href="/" onclick="excluirCidade(event, '+ data[i].idCidade +');"><i class="fa fa-lg fa-times" style="color:red"></i></a> </td>';
                tb += '</tr>';

                $('#tb_listaCidades').append(tb);
                $('.load').hide();
            }
        },
        error: function (err) {
            console.log('Erro ao listar cidades');
            $('.load').hide();
        }
    });
}

function alerta(tipoAlerta, mensagem){
    var add = '';
    switch (tipoAlerta) {
      case 'sucesso':
        add = '<div class="alert alert-success alert-dismissible fade show" role="alert"> <strong>Sucesso! </strong>' + mensagem +
                 '<button type="button" class="close" data-dismiss="alert" aria-label="Close"> ' +
                    '<span aria-hidden="true">&times;</span> ' +
                  '</button> ' +
              '</div>'
        break;
      case 'erro':
        add = '<div class="alert alert-danger alert-dismissible fade show" role="alert"> <strong>Erro! </strong>' + mensagem +
                 '<button type="button" class="close" data-dismiss="alert" aria-label="Close"> ' +
                    '<span aria-hidden="true">&times;</span> ' +
                  '</button> ' +
              '</div>'
        break;
      default:
        console.log('Tipo de alerta não encontrado!');
    }

    $('#alert').append(add);
}

function excluirCidade(event, id){
     event.preventDefault();

     $('.load').show();
     $('.alert').alert('close')

     if(confirm('Deseja realmente excluir?')){
        $.ajax({
            url: 'cidades/excluirCidade?id=' + id,
            type: 'GET',
            success: function (data) {
               alerta('sucesso', 'A cidade foi excluida com sucesso!');
               $('#'+id).remove();
               $('.load').hide();
            },
            error: function (err) {
                console.log('Erro ao excluir cidade');
                alerta('erro', 'Não foi possivel excluir a cidade!');
                $('.load').hide();
            }
        });
     }else {
        $('.load').hide();
     }

}

$(document).ready(function() {

    listarCidades();

   $('#cadastraCidade').on('click', function(){
        buscarCidade();
   });

});
