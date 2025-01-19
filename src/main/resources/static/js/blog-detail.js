'use strict';

$(document).ready(function () {
	// ブログ削除時の確認ダイアログ
	$(".blog-delete-form").on("submit", function (event) {
		event.preventDefault();
		const confirmation = confirm("ブログを削除してよろしいですか？");
		if (confirmation) {
			this.submit();
		}
	});

	const md = window.markdownit(); // markdown-itを初期化

	// HTML内のグローバル変数からMarkdownコンテンツを取得
	if (typeof blogContent !== "undefined") {
		// MarkdownをHTMLに変換
		const htmlContent = md.render(blogContent);
		$('.blog-content').html(htmlContent);
	} else {
		console.error("blogContent is undefined. Please check the template.");
	}
});
