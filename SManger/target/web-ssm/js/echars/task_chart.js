
function createHistogram(id,datas,legendstr,colstr) {
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom);
	var legs=legendstr.split(",");
	var cols=colstr.split(",");
	var seas=new Array();
	for(var k=0;k<legs.length;k++){
		var datao=new Object();
		datao.name=legs[k];
		datao.type='bar';
		for(var i=0;i<datas.length;i++){
			if(datas[i]["rowname"]==datao.name){
				var innera=new Array();
				for(var b=0;b<cols.length;b++){
					innera[b]=datas[i][cols[b]];
				}
				datao.data=innera;
				break;
			}
		}
		
		seas[k]=datao;
	}
	
	var option = {
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend: {
			data:legs
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : cols
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series :seas
	};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}

