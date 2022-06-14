setting = request.getAttribute("result_setting"); {
	if (setting = "更新成功！")	{
		window.alert('登録情報を変更しました');
	} else if (setting = "更新失敗！"){
		window.alert('更新に失敗しました');
	}
}