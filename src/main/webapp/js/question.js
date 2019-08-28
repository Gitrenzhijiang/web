function toQuesMain(){
	window.location = "toQuesMain";
}

function newQuestion (){
	alert ('新建一份问卷调查，先填写标题。')
}

function deleteQyestion(){
	var mainId=$("#tempId").val();	
//	var title=${"#title"}.val();
	//获取Id为tempId的input值
	$.ajax({
		url:basePath+"quesMain/quesDeleOne?id="+mainId,	//请求地址，把mainId加入路径当中
		type:'get',							//使用delete请求方式，rest风格
		success:function (data){// data.success data是一个js对象, 他如果有success属性，true
           // window.location.reload();// 删除了15，重新请求当前url addxxx,所以又加了一条。
           //  $("#delModal").modal('toggle');
           window.location = "toQuesMain";
//           window.location = "toQuesMain?title="+title;
		}
	});
}

function delModal (mainId){
	$("#tempId").val(mainId);		//设置Id为tempId的input值为主表Id
//	$("#title").val(title);			//存储模糊查询的字符串
	$("#delModal").modal();	
			//显示友好提示框
}

function delCheckModal (){
	$("#delCheckModal").modal();
}

function submitForm(formid,urlparm){
	//var formData = new FormData($(formid)[0]);
	$.ajax({
	url: urlparm,
	type: 'POST',
	data: {username:'username',password:'password'},
	async: false,
	cache: false,
	contentType: 'text/xml',
	processData: false,
	success: function(data){
		if(data.success) {
			window.location.reload();
		}
	},
	error: function(){
		alert ('服务器问题。');
	}
	});
}

function submitFormDel(formid,urlparm){
	
	var names = $("input[name='id']:checked").serialize();
	
	$.ajax({
	url: urlparm+"?"+names,
	type: 'POST',
	async: false,
	cache: false,
	contentType: 'text/xml',
	processData: false,
	success: function(data){
		if(data.success) {
			window.location.reload();

		}
	},
	error: function(){
		alert ('服务器问题。');
	}
	});
}

function delQuestionModal (QuestionId){
	
	$("#tempQuestionId").val(QuestionId);
	$("#delQuestionModal").modal();
	
}

//删除一个问题
function delWt (questionId){
	
	$.ajax({
		url:basePath+"quesMain/questionDele?id="+$("#tempQuestionId").val(),
		type:'DELETE',
		success:function (data){
			window.location = "toQuesNaire?id="+$("#questionnaireId").val();
		}
	});
	
}

function deleteQuestion (){
	ale
	var questionId = $("#tempQuestionId").val();
	$.ajax({
		url:basePath+"question?method=delectQuestion&id="+questionId,
		type:'DELETE',
		success:function (data){
			window.location = "question?method=addQuestion&id="+questionId;
		}
	});
}

function pauseModel (mainId){
	
	$("#temppauseMainId").val(mainId);
//	$("#title").val(title);
	$("#pauseModel").modal();
}

function pause (){
	$.ajax({
		url:basePath+"quesMain/quesStop?id="+$("#temppauseMainId").val(),
		type:'PUT',
		success:function (data){
            window.location = "toQuesMain";
//            window.location = "toQuesMain?title="+$("#title").val();
		}
	});
}

//发布问卷
function actionModel (mainId){
	$("#tempActionMainId").val(mainId);
//	$("#title").val(title);
	$("#actionModal").modal();
}


function actionStart (){
	$.ajax({
		url:basePath+"quesMain/quesStart?id="+$("#tempActionMainId").val(),
		type:'get',
		success:function (data){
            window.location = "toQuesMain";
//            window.location = "toQuesMain?title="+$("#title").val();
		}
	});
}

function submitAnswer(formid,urlparm){
	var formData = new FormData($(formid)[0]);
	$.ajax({
	url: urlparm,
	type: 'POST',
	data: formData,
	async: false,
	cache: false,
	contentType: false,
	processData: false,
	success: function(data){
		if(data.success) {
			var pText = document.getElementById("alertOKText");
			pText.innerText = "非常感谢您的认真回答";
			$("#alertOK").modal();
		}else{
			window.location.href=basePath+"question/goLowError";
		}
	},
	error: function(){
		alert ('服务器问题。');
	}
	});
}

function submitFormById (formId){
	$('#'+formId).submit();		//表单提交
}

function copyQuestion (mainId){
	$.ajax({
		url:basePath+"question/copy/"+mainId,
		type:'GET',
		success:function (data){
			if (data.success){
				var pText = document.getElementById("alertOKText");
				pText.innerText = "拷贝成功，页面于三秒内刷新";
				$("#alertOK").modal();
				setTimeout("window.location.reload()",3000);
			}else{
				var pText = document.getElementById("alertOKText");
				pText.innerText = "拷贝失败";
				$("#alertOK").modal();
				
			}
		}
	});
}

function showEdit(){
	
	$("#editform").show();
	$("#h5maintitle").hide();
	$("#btnxg").hide();
	$("#btnbc").show();
	$("#btnqx").show();
	
}

function cancelEdit(){

	$("#editform").hide();
	$("#h5maintitle").show();
	$("#btnxg").show();
	$("#btnbc").hide();
	$("#btnqx").hide();
}

function editQuestionMainTitle (mainId){
	
	var MainTitle = $("#mainTitleInput").val();
	var MainEndtime = $("#mainEndtimeInput").val();
	
	$.ajax({
		url:basePath+"quesMain/editQuesNatre",
		type:'POST',
		data:{id:mainId,
			title:MainTitle,
			dtime:MainEndtime
		},
		success:function (data){
				$("#alertOK").modal();
				$("#h5maintitle").html(MainTitle);
				cancelEdit();
			 // window.location = "question?method=showQuestionnaire&id="+mainId;
			
		}
	});
}

function closepage (){
	
	window.opener = null;
	window.open("","_self");
	window.close();
	
}

function openEditModel (){
	$("#editModal").modal('show');
	$("div[name='div_answers']").remove();
	answerPro.num = 1;
}

var answerPro = {
		"num":1
};

function addAnswer() {
	var guidr = guid();		//生成guid作为  生成不同的数据
	$("#editAnswer").append("<div class='form-group' name='div_answers' id='div_answer"
			+guidr+"'><label>答案"+answerPro.num+":</label>"
			+"<div class='input-group'>"
			+"<input class='form-control' name='"+guidr+"' type='text' />"
			+"<div class='input-group-btn'>"
			+"<buttion class='btn btn-primary' type='button' onclick=\"delAddAnswer('"
			+guidr+"')\">删除</bution></div></div>"
			+"<input type='file' name='"+guidr+"'  /></div>");
	answerPro.num++;		//答案编号自加1
}

function delAddAnswer(num) {
	//根据传递过来的guid获取div，并将其移除
	$('#'+('div_answer'+num)).remove();
	var i = 1;
	//重新排序
	var elementLabel = $("div[name='div_answers']").find("label").each(function (){
		$(this).html("答案"+i+":");
		i++;
	});
	answerPro.num = i;
}

//function openEditModelxg (questionId){
//	$("#editModalxg").modal('show');
//	$("div[name='div_answersxg']").remove();
//	
//	$.ajax({
//		url:basePath+"quesMain/showQuestion?id="+questionId,
//		type:'GET',
//		success:function (data){
////			data = JSON.parse(data);
//			var answers = data.answers;
//			var question = data.question;
//			console.log(answers);
//			console.log(question);
//			$("#questionIdxg").val(question.id);
//			$("#questionTitlexg").val(question.text);
//			$("#no").val(question.no);
//			$("#questionNaireIdxg").val(question.questionnaire_id);
//			$("#questionTypexg option[value="+question.type+"]").attr("selected","selected");
//			var i=0;
//			for (i;i<answers.length;i++){
//				var guidr = guid();	
//				if (answers[i].path == null){
//					var temp = answers[i].text;
//					var tempAnswerDestype = temp;
//				}else{
//					var temp = answers[i].path;
//					var tempAnswerDestype = temp;
//				}
//				$("#editAnswerxg").append("<div class='form-group' name='div_answersxg' id='div_answerxg"+guidr+"'><label>答案"+(i+1)+":</label>"
//						+"<div class='input-group'>"
//						+"<input class='form-control' name='"+answers[i].id+"' type='text' value='"+tempAnswerDestype+"' />"
//						+"<div class='input-group-btn'><buttion class='btn btn-primary' type='button' onclick=\"delAddAnswerxg('"+guidr+"')\">删除</bution></div></div>"
//						+"<input type='file' name='"+answers[i].id+"' /></div>");
//			}
//			answerPro.num = i+1;
//			
//		}
//	});
//	
//}

//function addAnswerxg() {
//	var guidr = guid();
//	$("#editAnswerxg").append("<div class='form-group' name='div_answersxg' id='div_answerxg"+guidr+"'><label>答案"+answerPro.num+":</label>"
//			+"<div class='input-group'>"
//			+"<input class='form-control' name='"+guidr+"' type='text' />"
//			+"<div class='input-group-btn'><buttion class='btn btn-primary' type='button' onclick=\"delAddAnswerxg('"+guidr+"')\">删除</bution></div></div>"
//			+"<input type='file' name='"+guidr+"'  /></div>");
//	answerPro.num++;
//}

function openEditModelxg (questionId){
	$("#editModalxg").modal('show');
	$("div[name='div_answersxg']").remove();
	
	$.ajax({
		url:basePath+"quesMain/showQuestion?id="+questionId,
		type:'GET',
		success:function (data){
			var answers = data.answers;
			var question = data.question;
			console.log(answers);
			console.log(question);
			$("#questionIdxg").val(question.id);
			$("#questionTitlexg").val(question.text);
			$("#no").val(question.no);
			$("#questionNaireIdxg").val(question.questionnaire_id);
			$("#questionTypexg option[value="+question.type+"]").attr("selected","selected");
			var i=0;
			for (i;i<answers.length;i++){
				var guidr = guid();	
				var answerid = answers[i].id
				if (answers[i].path == null){
					var temp = answers[i].text;
					var tempAnswerDestype = temp;
				}else{
					var temp = answers[i].path;
					var tempAnswerDestype = temp;
				}
				$("#editAnswerxg").append("<div class='form-group' name='div_answersxg' id='div_answerxg"+guidr+"'><label>答案"+(i+1)+":</label>"
						+"<div class='input-group'>"
						+"<input class='form-control' name='answerid' type='hidden' value='"+answerid+"'/>"
						+"<input class='form-control' name='answertext' type='text' value='"+tempAnswerDestype+"' />"
						+"<div class='input-group-btn'><buttion class='btn btn-primary' type='button' onclick=\"delAddAnswerxg('"+guidr+"')\">删除</bution></div></div>"
						+"<input type='file' name='answerpath' /></div>");
			}
			answerPro.num = i+1;
			
		}
	});
	
}

function addAnswerxg() {
	var guidr = guid();
	$("#editAnswerxg").append("<div class='form-group' name='div_answersxg' id='div_answerxg"+guidr+"'><label>答案"+answerPro.num+":</label>"
			+"<div class='input-group'>"
			+"<input class='form-control' name='answerid' type='hidden' value='"+guidr+"'/>"
			+"<input class='form-control' name='answertext' type='text' />"
			+"<div class='input-group-btn'><buttion class='btn btn-primary' type='button' onclick=\"delAddAnswerxg('"+guidr+"')\">删除</bution></div></div>"
			+"<input type='file' name='answerpath0'  /></div>");
	answerPro.num++;
}

function delAddAnswerxg(num) {
	$('#'+('div_answerxg'+num)).remove();
	var i = 1;
	var elementLabel = $("div[name='div_answersxg']").find("label").each(function (){
		$(this).html("答案"+i+":");
		i++;
	});
	answerPro.num = i;
}