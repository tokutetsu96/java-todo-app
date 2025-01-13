'use strict';

$(document).ready(function() {
	// 画像プレビューを表示する関数
	$('#image').on('change', function(event) {
		const input = event.target;
		const preview = $('#imagePreview');

		if (input.files && input.files[0]) {
			const reader = new FileReader();

			reader.onload = function(e) {
				preview.attr('src', e.target.result);
				preview.show(); // プレビューを表示
			};

			reader.readAsDataURL(input.files[0]);
		}
	});
});
