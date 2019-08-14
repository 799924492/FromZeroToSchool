$(function () {
    var initUrl = '/tomcat/shopadmin/getshopinitinfo'
    var registerShopUrl = '/tomcat/shopadmin/registershop'
    getShopInitInfo()

    function getShopInitInfo() {

        $.getJSON(initUrl, function (data) {

            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategories.map(function (item, index) {

                    tempHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {

                    tempAreaHtml +='<option data-id="'+item.areaId+'">'+item.areaName+'</option>';

                });

                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        })};

        $("#submit").click(function () {
            var shop = {};
            shop.shopName = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').val();
            shop.phone = $('#shop-phone').val();
            shop.shopDesc = $('#shop-desc').val();
            shop.shopCategory = {

                shopCategoryId : $('#shop-category').find('option').not(function() {

                    return !this.selected;

                }).data('id')

            };

// 选择选定好的区域信息

            shop.area = {

                areaId : $('#area').find('option').not(function() {

                    return !this.selected;

                }).data('id')

            };
            var shopImg = $('#shop-img')[0].files[0];
            var formData = new FormData();
            formData.append('shopImg', shopImg);

            formData.append('shopStr', JSON.stringify(shop));
            var varifyCodeActual = $('#j_captcha').val();
            if (!varifyCodeActual) {
                $.toast("请输入验证码");
                return;
            }
            {
                formData.append('verifyCodeActual', varifyCodeActual);
            }

            $.ajax({

                url: registerShopUrl,
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {

                    if (data.success) {
                        $.toast("提交成功")
                    } else {
                        $.toast("失败")
                    }
                    $('#captcha_img').click();
                }

            });
        });




})