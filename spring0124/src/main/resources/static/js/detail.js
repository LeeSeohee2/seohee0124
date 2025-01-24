// detail.css

$(function() {
   // 1. 하트 아이콘을 눌렀을 때
   // 2. 빨간하트로 변경하기!

    $('#heart-icon').on('click', function() {
        // this 이벤트가 발생한 객체!
        let heartIcon = $(this);

        // 클래스 있는지 없는지 확인하는 함수
        //  hasClass(클래스명)
        let isLiked = heartIcon.hasClass('liked');
        console.log("하트 결과:",isLiked);
        heartIcon.toggleClass('bi-heart bi-heart-fill liked');

        // 2. 비동기통신을 받는 RestController생성하고
        //   하트가 눌렀는지 안 눌렀는 지 결과를 가지고
        //   디비에 있는 heart_count값을 증가하거나 감소하기!
        //   그 값을 응답받아서 하트의 숫자를 출력하는 p태그에
        //   새로 저장하기!
        let productId = $("#product-info-image").attr("alt");
        console.log(productId);

        // ajax
        $.ajax({

            url: '/product/heart',
            method: 'POST',
            contentType: 'application/json',
            data:JSON.stringify({
                productId:productId,
                action : isLiked ? 'unlike':'like'}),
            success: function(data) {
                console.log(data);
            },
            error: function(data) {
                console.error(data);
            }
        });// ajax끝!


    });


});