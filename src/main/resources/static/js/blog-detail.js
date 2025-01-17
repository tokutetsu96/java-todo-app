'use strict';

$(document).ready(function () {
	$(".blog-delete-form").on("submit", function (event) {
		event.preventDefault();
		const confirmation = confirm("ブログを削除してよろしいですか？");
		if (confirmation) {
			this.submit();
		}
	});
});
