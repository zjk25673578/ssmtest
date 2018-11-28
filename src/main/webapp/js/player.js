layui.config({
    base: '../lib/ckplayer/'
}).extend({
    ckplayer: 'ckplayer'
}).use(['jquery', 'ckplayer'], function () {
    var $ = layui.$,
        ckplayer = layui.ckplayer;

    var vUrl1 = $('#video1').data('url'),
        videoObject1 = {
            container: '#video1',
            loop: true,
            autoplay: false,
            video: [
                [vUrl1, 'video/mp4']
            ]
        };
    var vUrl2 = $('#video2').data('url'),
        videoObject2 = {
            container: '#video2',
            loop: true,
            autoplay: false,
            video: [
                [vUrl2, 'video/mp4']
            ]
        };
    var player1 = new ckplayer(videoObject1);
    var player2 = new ckplayer(videoObject2);
});