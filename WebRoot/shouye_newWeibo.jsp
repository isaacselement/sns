<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
<title></title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<script type="text/javascript" src="showMessages.js"></script>

<style type="text/css">

ul,li {
	margin: 0;
	padding: 0;
	list-style: none;
}

.wp {
	position: relative;
	width: 627px;
	height: 406px;
	overflow: hidden;
	margin: left;
	border: 0px solid #ccc;
}

.slider {
	position: absolute;
	width: 450px;
	padding: 20px;
	left: 0;
	top: 0;
}

.fl {
	float: left;
}

.slider img {
	display: block;
	padding: 2px;
	border: 1px solid #ccc;
}

.slider li {
	padding: 20px 0;
	border-bottom: 0px dashed #ccc;
	overflow: hidden;
	width: 100%;
}

.slider p {
	font-size: 12px;
	margin: 0;
	padding-left: 58px;
	color: #000;
	line-height: 20px;
}
</style>
<script type="text/javascript">
	function H$(i) {
		return document.getElementById(i)
	}
	function H$$(c, p) {
		return p.getElementsByTagName(c)
	}
	var slider = function() {
		function init(o) {
			this.id = o.id;
			this.at = o.auto ? o.auto : 3;
			this.o = 0;
			this.pos();
		}
		init.prototype = {
			pos : function() {
				clearInterval(this.__b);
				this.o = 0;
				var el = H$(this.id), li = H$$('li', el), l = li.length;
				var _t = li[l - 1].offsetHeight;
				var cl = li[l - 1].cloneNode(true);
				cl.style.opacity = 0;
				cl.style.filter = 'alpha(opacity=0)';
				el.insertBefore(cl, el.firstChild);
				el.style.top = -_t + 'px';
				this.anim();
			},
			anim : function() {
				var _this = this;
				this.__a = setInterval(function() {
					_this.animH()
				}, 20);
			},
			animH : function() {
				var _t = parseInt(H$(this.id).style.top), _this = this;
				if (_t >= -1) {
					clearInterval(this.__a);
					H$(this.id).style.top = 0;
					var list = H$$('li', H$(this.id));
					H$(this.id).removeChild(list[list.length - 1]);
					this.__c = setInterval(function() {
						_this.animO()
					}, 20);
					//this.auto();
				} else {
					var __t = Math.abs(_t) - Math.ceil(Math.abs(_t) * .07);
					H$(this.id).style.top = -__t + 'px';
				}
			},
			animO : function() {
				this.o += 2;
				if (this.o == 100) {
					clearInterval(this.__c);
					H$$('li', H$(this.id))[0].style.opacity = 1;
					H$$('li', H$(this.id))[0].style.filter = 'alpha(opacity=100)';
					this.auto();
				} else {
					H$$('li', H$(this.id))[0].style.opacity = this.o / 100;
					H$$('li', H$(this.id))[0].style.filter = 'alpha(opacity='
							+ this.o + ')';
				}
			},
			auto : function() {
				var _this = this;
				this.__b = setInterval(function() {
					_this.pos()
				}, this.at * 1000);
			}
		}
		return init;
	}();
</script>
</head>
<body onload="showMes()">
	<div class="wp">
		<span>大家正在说:</span>
		<ul id="slider" class="slider">
			<li></li>
		</ul>
	</div>
	<script type="text/javascript">
		new slider({
			id : 'slider'
		})
	</script>
</body>
</html>
