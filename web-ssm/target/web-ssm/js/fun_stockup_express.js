//上下关联
function updown_express(btn){
	next_express(btn);
	prev_express(btn);
}

//向下关联
function next_express(btn){
	var value = btn;
	
	if ($("#txt" + value).val() == ''){
		alert("请扫描快递单号");
		return;
	}
	
	var str = $("#txt" + value).val();

	if (express_company_no){
		switch(express_company_no)
		{
			case 'EMS'://EMS
			if (isEMSNo(str)){
				enterNextNo(btn,express_company_no);
				return ;
			}
			break;

			case 'SF'://顺丰
			if (isSFNo(str)){
				enterNextNo(btn,express_company_no);
				return ;
			}
			break;
			
			case 'ZJS'://宅急送
			if (isZJSNo(str)){
				enterNextNo(btn,express_company_no);
				return ;
			}
			break;
		}
	}

	var end = str.substr(str.length-1, 1);
	if(!is_num(end)){
		alert('请输入正确的快递单号!');
		return ;
	}
	
	var num = str.match(/[1-9]\d*\b/g);
	var len = str.lastIndexOf(num);
	var start = str.substring(0,len);
	var n = new Number(num)+1;

	var ctxt;
	while (true)
	{
		var aa = value + 1;

		if (typeof($("#txt" + aa).val()) != 'undefined')
		{
			$("#txt" + aa).attr('value',start + n);
			n++;
			value++;
		}else {
			break;
		}
	}

	return;
}
    
//向上关联
function prev_express(value)
{
	if ($("#txt" + value).val() == ''){
		alert("请扫描快递单号");
		return;
	}
	
	var str = $("#txt" + value).val();
	if (express_company_no){
		switch(express_company_no)
		{
			case 'EMS'://EMS
			if (isEMSNo(str)){
				enterPrevNo(value,express_company_no);
				return ;
			}
			break;

			case 'SF'://顺丰
			if (isSFNo(str)){
				enterPrevNo(value,express_company_no);
				return ;
			}
			break;

			case 'ZJS'://宅急送
			if (isZJSNo(str)){
				enterPrevNo(value,express_company_no);
				return ;
			}
			break;
		}
	}

	var end = str.substr(str.length-1, 1);
	if(!is_num(end)){
		alert('请输入正确的快递单号!');
		return ;
	}

	num = str.match(/[1-9]\d*\b/g);
	len = str.lastIndexOf(num);
	start = str.substring(0,len);
	n = new Number(num)-1;
        
	var ctxt;
	while (true)
	{
		var bb = value-1;
		if (typeof($("#txt" + bb).val()) != 'undefined')
		{
			if(n>=0){
				$("#txt" + bb).attr('value',start + n);
			}else{
				$("#txt" + bb).attr('value','');
			}

			n--;
			value--;
		}else{
			break;
		}
	}

	return;
}

//向下关联单号填充
function enterNextNo(btn,company_no)
{
	var value = btn;
	while (true){
		var newid = value+1;
		if (typeof($("#txt" + newid).val()) != 'undefined')
		{
			switch(company_no){
				case 'EMS':
					$("#txt" + newid).attr('value',getEMSNext($('#txt' + value).val()));
					break;
				case 'SF':
					$("#txt" + newid).attr('value',getSFNext($('#txt' + value).val()));
					break;
				case 'ZJS':
					$("#txt" + newid).attr('value',getZJSNext($('#txt' + value).val()));
					break;
			}
			value++;
		}else {
			break;
		}
	}
	return ;
}

//向上关联单号填充
function enterPrevNo(btn,company_no)
{
	value = btn;
	while (true){
		var newid = value - 1;
		if (typeof($("#txt" + value).val()) != 'undefined')
		{
			switch(company_no)
			{
				case 'EMS':
				$("#txt" + newid).attr('value',getEMSPrev($('#txt' + value).val()));
				break;

				case 'SF':
				alert('不支持向上关联');
				return;
				//$("#txt" + newid).attr('value',getSFPrev($('#txt' + value).val()));
				break;

				case 'ZJS':
				$("#txt" + newid).attr('value',getZJSPrev($('#txt' + value).val()));
				break;
			}
			value--;
		}else {
			break;
		}
	}
	
	return ;
}

//-------------------------------EMS快递单号关联
function isEMSNo(no){
	if (no.length != 13){
		return false;
	}
        
	if (getEMSLastNum(no) == no.substr(10,1))
	{
		return true;
	}else{
		return false;
    }
}

function getEMSLastNum(no)
{
	var v = new Number(no.substr(2,1)) * 8;
	v += new Number(no.substr(3,1)) * 6;
	v += new Number(no.substr(4,1)) * 4;
	v += new Number(no.substr(5,1)) * 2;
	v += new Number(no.substr(6,1)) * 3;
	v += new Number(no.substr(7,1)) * 5;
	v += new Number(no.substr(8,1)) * 9;
	v += new Number(no.substr(9,1)) * 7;
	v = 11 - v % 11;
	if (v == 10)
		v = 0;
	else if (v == 11)
		v = 5;
	return v.toString();
} 

//上一个快递单号
function getEMSPrev(no)
{
	var serialNo = no.substr(2,8); 
	if (serialNo > 0)
		serialNo--;
	strSerialNo = pad(serialNo, 8);
	temp = no.substr(0,2) + strSerialNo + no.substr(10,1);
	temp = no.substr(0,2) + strSerialNo + getEMSLastNum(temp) + no.substr(11,2);
	return temp;
}

//下一个快递单号
function getEMSNext(no)
{
	var serialNo = no.substr(2,8);
	if (serialNo < 99999999)
		serialNo++;
	strSerialNo = pad(serialNo, 8);
	temp = no.substr(0,2) + strSerialNo + no.substr(10,1);
	temp = no.substr(0,2) + strSerialNo + getEMSLastNum(temp) + no.substr(11,2);
	return temp;
}

//-----------------------------顺丰快递单号
//验证是否顺丰快递单号
function isSFNo(no){
	
	if (!is_num(no)){
		return false;
	} else {
		return true;
	}
}

//上一个快递单号
function getSFPrev(no)
{
	return false;
}

//下一个快递单号
function getSFNext(ShunFengNo)
{
	var fri,Nfri,Yuandanhao;
	var res;
	var num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12;
	var Nnum1,Nnum2,Nnum3,Nnum4,Nnum5,Nnum6,Nnum7,Nnum8,Nnum9,Nnum10,Nnum11,Nnum12;
	var mid,I,ShunFengres;

	ShunFengres = '';
	fri = ShunFengNo.substr(0,11);
	Yuandanhao = ShunFengNo;
	//先将前11位加1，存储为新前11位
	
	Nfri = ShunFengNo.substr(0,1) + String(Math.abs(fri)+1);
	//获取原始前11位
	num1 = Math.abs(Yuandanhao.substr(0,1));
	num2 = Math.abs(Yuandanhao.substr(1,1));
	num3 = Math.abs(Yuandanhao.substr(2,1));
	num4 = Math.abs(Yuandanhao.substr(3,1));
	num5 = Math.abs(Yuandanhao.substr(4,1));
	num6 = Math.abs(Yuandanhao.substr(5,1));
	num7 = Math.abs(Yuandanhao.substr(6,1));
	num8 = Math.abs(Yuandanhao.substr(7,1));
	num9 = Math.abs(Yuandanhao.substr(8,1));
	num10 = Math.abs(Yuandanhao.substr(9,1));
	num11 = Math.abs(Yuandanhao.substr(10,1));
	num12 = Math.abs(Yuandanhao.substr(11,1));
	//获取新前11位
	Nnum1 = Math.abs(Nfri.substr(0,1));
	Nnum2 = Math.abs(Nfri.substr(1,1));
	Nnum3 = Math.abs(Nfri.substr(2,1));
	Nnum4 = Math.abs(Nfri.substr(3,1));
	Nnum5 = Math.abs(Nfri.substr(4,1));
	Nnum6 = Math.abs(Nfri.substr(5,1));
	Nnum7 = Math.abs(Nfri.substr(6,1));
	Nnum8 = Math.abs(Nfri.substr(7,1));
	Nnum9 = Math.abs(Nfri.substr(8,1));
	Nnum10 = Math.abs(Nfri.substr(9,1));
	Nnum11 = Math.abs(Nfri.substr(10,1));
	if ( Nnum9-num9==1 && (num9)%(2)==1 ){
		if (num12-8 >= 0)
			Nnum12 = num12-8             // -8
		else
			Nnum12 = num12-8 +10
	}else if( Nnum9-num9==1 && (num9)%(2)==0 ){
		if (num12-7 >=0)
			Nnum12 = num12-7             // -7
		else
			Nnum12 = num12-7 +10
	}else{
		if( ((num10==3) || (num10==6))&& (num11==9) ){
			if (num12-5 >=0)
				Nnum12 = num12-5             // -5
			else
				Nnum12 = num12-5 +10
		}else if (num11==9){
			if (num12-4 >=0)
				Nnum12 = num12-4             // -4
			else
				Nnum12 = num12-4 +10
		}else{
			if (num12-1 >=0)
				Nnum12 = num12-1            // -1
			else
				Nnum12 = num12-1 +10
		}
	}
	ShunFengres = Nfri+String(Nnum12);
	return ShunFengres;
}

//-----------------------------宅急送递单号
function isZJSNo(no){
	if (!is_num(no)){
		return false;
	}else{
		return true;
	}
}

function getZJSPrev(no){
	var retNo = Math.abs(no);
	if (retNo % 10 == 0)
		retNo -= 4;
	else
		retNo -= 11;
	return pad(retNo, no.length);
}

function getZJSNext(no){
	var retNo = no;
	retNo = Math.abs(retNo) + 11;
	if (retNo % 10 > 6){
		retNo -= 7;
	}
	return pad(retNo, no.length);
}

function pad(num, n) {
	return Array(Math.abs((''+num).length-(n+1))).join(0)+num;
}

function is_num(str){
	var pattrn = /^[0-9]+$/;
	if (pattrn.test(str)){
		return true;
	}else{
		return false;
	}
}


//倒序关联单号
//var value = ;
function reversevNo()
{
	//var value = btn;
	var _value = new Array();

	for(var i = value.length; i > 0;i--){
		_value.push(value[i-1]);
	}

	for(var i = 0; i < _value.length;i++){
		var aa = i+1;
		if ($("#txt"+aa)){
			$("#txt"+aa).value = _value[i];
		}
	}

	return ;
}