'use strict';

$(document).ready(function() {
	$('#deleteButton').on('click', function() {
		// Hidden fieldの値を取得
		const todoId = $('#todoId').val();
		// 確認ダイアログ
		if (confirm('本当に削除しますか？')) {
			// フォームのaction属性を更新
			$('#deleteForm').attr('action', `/todo/delete/${todoId}`);
			// フォームを送信
			$('#deleteForm').submit();
		}
	});
});