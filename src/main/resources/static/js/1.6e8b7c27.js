(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[1],{"DrR/":function(t,e,n){},NfVS:function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("error-content",{attrs:{code:"404",desc:"Oh~~您的页面好像飞走了~",src:t.src}})},c=[],o=n("xDY3"),s=n.n(o),a=n("lFQy"),i={name:"error_404",components:{errorContent:a["a"]},data:function(){return{src:s.a}}},u=i,l=n("uMhA"),d=Object(l["a"])(u,r,c,!1,null,null,null);e["default"]=d.exports},lFQy:function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"error-page"},[n("div",{staticClass:"content-con"},[n("img",{attrs:{src:t.src,alt:"404"}}),n("div",{staticClass:"text-con"},[n("h4",[t._v(t._s(t.code))]),n("h5",[t._v(t._s(t.desc))])]),n("back-btn-group",{staticClass:"back-btn-group"})],1)])},c=[],o=(n("DrR/"),function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("Button",{attrs:{size:"large",type:"text"},on:{click:t.backHome}},[t._v("返回首页")]),n("Button",{attrs:{size:"large",type:"text"}},[t._v("返回上一页("+t._s(t.second)+"s)")])],1)}),s=[],a=(n("pIFo"),{name:"backBtnGroup",data:function(){return{second:5,timer:null}},methods:{backHome:function(){this.$router.replace({name:"home"})},backPrev:function(){this.$router.go(-1)}},mounted:function(){var t=this;this.timer=setInterval(function(){0===t.second?t.backPrev():t.second--},1e3)},beforeDestroy:function(){clearInterval(this.timer)}}),i=a,u=n("uMhA"),l=Object(u["a"])(i,o,s,!1,null,null,null),d=l.exports,p={name:"error_404",components:{backBtnGroup:d},props:{code:String,desc:String,src:String}},f=p,v=Object(u["a"])(f,r,c,!1,null,null,null);e["a"]=v.exports},pIFo:function(t,e,n){n("IU+Z")("replace",2,function(t,e,n){return[function(r,c){"use strict";var o=t(this),s=void 0==r?void 0:r[e];return void 0!==s?s.call(r,o,c):n.call(String(o),r,c)},n]})},xDY3:function(t,e,n){t.exports=n.p+"img/error-404.94756dcf.svg"}}]);
//# sourceMappingURL=1.6e8b7c27.js.map