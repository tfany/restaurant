webpackJsonp([8],{RsHH:function(e,t){},S49b:function(e,t,r){"use strict";t.a=function(){return Object(s.a)({url:"/manager/shopInformation",method:"get"})},t.c=function(e){return Object(s.a)({url:"/manager/updateShop",method:"post",data:e})},t.b=function(e){return Object(s.a)({url:"/manager/getQRcode?deskNum="+e,method:"post"})};var s=r("vLgD")},r9NU:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r("S49b"),a={data:function(){return{value:{deskNum:""},url:"",srcList:[],rules:{deskNum:[{required:!0,message:"请输入店铺桌号",trigger:"blur"},{min:1,max:10,message:"长度在 1 到 10 个数字",trigger:"blur"}]}}},methods:{commit:function(){var e=this;Object(s.b)(this.value.deskNum).then(function(t){e.url=t.data,e.srcList.push(e.url),console.log(e.url),e.$message({type:"success",message:"提交成功",duration:1e3})}),this.$router.push({path:"/info/qrcode"})}}},u={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"center"},[r("el-card",{staticClass:"box-card"},[r("el-form",{staticStyle:{width:"600px"},attrs:{model:e.value,rules:e.rules,"label-width":"120px",size:"small"}},[r("el-form-item",{attrs:{label:"桌号：",prop:"deskNum"}},[r("el-input-number",{attrs:{min:0,"controls-position":"right"},model:{value:e.value.deskNum,callback:function(t){e.$set(e.value,"deskNum",t)},expression:"value.deskNum"}})],1),e._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){e.commit()}}},[e._v("生成")])],1)],1),e._v(" "),""!==e.url?r("div",{staticClass:"image-preview"},[r("el-image",{staticStyle:{width:"300px",height:"300px"},attrs:{src:e.url[1],"preview-src-list":e.srcList}})],1):e._e()],1)],1)},staticRenderFns:[]};var i=r("VU/8")(a,u,!1,function(e){r("RsHH")},"data-v-f17fad16",null);t.default=i.exports}});
//# sourceMappingURL=8.b820398a4292992bb956.js.map