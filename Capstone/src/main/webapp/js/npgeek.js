$(function(){
	$('.sideNav').on('click', function(){
		var code = $(this).attr('id');
//		$('.sideNav .active').removeClass('active');
		$('#'+code).addClass('active');
	});
});