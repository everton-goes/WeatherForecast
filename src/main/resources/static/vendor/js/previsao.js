function previsaoCidade(){
    var params = window.location.search.substring(1).split('?');
    var paramArray = {};

    for(var i = 0; i < params.length; i++) {
        var param = params[i].split('=');
        var chave = param[0];
        var valor = param[1];

        paramArray[chave] = valor;
    }

    preencheTituloPrevisao(paramArray['idCidade'])
    preenchePrevisao(paramArray['idCidade'])
}

function preencheTituloPrevisao(idCidade){
    $.ajax({
        url: 'cidades/buscaCidadePorId?idCidade=' + idCidade,
        type: 'POST',
        success: function (data) {
            $('#tituloPrevisao').append('<h5 class="mt-5">Previsão do Tempo para '+ data.nomeCidade +' nos próximos 5 dias</h5>')
        },
        error: function (err) {
            console.log('Erro ao preencher titulo da previsao');
            $('.load').hide();
        }
    });
}

function preenchePrevisao(idCidade){
    var apiKey = 'eb8b1a9405e659b2ffc78f0a520b1a46';

    $.ajax({
        url: 'https://api.openweathermap.org/data/2.5/forecast?id=' + idCidade + '&appid=' + apiKey + '&lang=pt_br&units=metric',
        type: 'GET',
        success: function (data) {
            for(var i = 0; i < data.list.length; i++){
                var iconSrc = 'https://openweathermap.org/img/wn/' + data.list[i].weather[0].icon + '.png';

                var dataFormatada = moment(data.list[i].dt_txt, 'YYYY-MM-DD HH:mm:ss', true).format('DD/MM/YYYY HH:mm');

                var tb = '';
                tb += '<tr>';
                tb += '	    <td class="table-primary text-center"><img src="'+ iconSrc +'"></td>';
                tb += '	    <td>'+ dataFormatada +' </td>';
                tb += '	    <td>'+ data.list[i].main.temp +' °C</td>';
                tb += '	    <td>'+ data.list[i].main.temp_min +' °C</td>';
                tb += '	    <td>'+ data.list[i].main.temp_max +' °C</td>';
                tb += '	    <td>'+ data.list[i].weather[0].description +' </td>';
                tb += '</tr>';

                $('#tb_listaPrevisao').append(tb);
            }

            $('.load').hide();
        },
        error: function (err) {
            console.log('Erro ao preencher previsao');
            $('.load').hide();
        }
    });
}

$(document).ready(function() {
    $('.load').show();
    previsaoCidade();
});