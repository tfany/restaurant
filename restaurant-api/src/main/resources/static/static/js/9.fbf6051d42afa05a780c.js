webpackJsonp([9],{D7p0:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("S49b"),l={data:function(){return{value:{id:"",name:"",image:"",url:"",notice:""},url:"http://localhost:8088/manager/uploadShopImg",rules:{name:[{required:!0,message:"请输入店铺名称",trigger:"blur"},{min:2,max:140,message:"长度在 2 到 140 个字符",trigger:"blur"}],url:[{required:!0,message:"请输入店铺URL",trigger:"blur"}],notice:[{required:!1,message:"请输入店铺公告",trigger:"blur"}],picture:[{required:!0,message:"请选择图片",trigger:"blur"}]}}},created:function(){this.getShopInfo()},methods:{getShopInfo:function(){var e=this;Object(r.a)().then(function(t){e.value=t.data})},handleUpload:function(e,t,a){this.value.image=e.data},commit:function(e){var t=this;Object(r.c)(this.value).then(function(e){t.$message({type:"success",message:"提交成功",duration:1e3})})}}},n={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"center"},[a("el-card",{staticClass:"box-card"},[a("el-form",{staticStyle:{width:"600px"},attrs:{model:e.value,rules:e.rules,"label-width":"120px",size:"small"}},[a("el-form-item",{attrs:{label:"店铺名称：",prop:"name"}},[a("el-input",{model:{value:e.value.name,callback:function(t){e.$set(e.value,"name",t)},expression:"value.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"店铺公告：",prop:"notice"}},[a("el-input",{model:{value:e.value.notice,callback:function(t){e.$set(e.value,"notice",t)},expression:"value.notice"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"首页地址：",prop:"url"}},[a("el-input",{model:{value:e.value.url,callback:function(t){e.$set(e.value,"url",t)},expression:"value.url"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"店铺图片：",prop:"picture"}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{action:e.url,name:"file","on-success":e.handleUpload,"show-file-list":!1}},[e.value.image?a("img",{staticClass:"avatar",attrs:{src:e.value.image}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){e.commit()}}},[e._v("提交")])],1)],1)],1)],1)},staticRenderFns:[]};var i=a("VU/8")(l,n,!1,function(e){a("rBlF")},"data-v-6e0cb2ca",null);t.default=i.exports},S49b:function(e,t,a){"use strict";t.a=function(){return Object(r.a)({url:"/manager/shopInformation",method:"get"})},t.c=function(e){return Object(r.a)({url:"/manager/updateShop",method:"post",data:e})},t.b=function(e){return Object(r.a)({url:"/manager/getQRcode?deskNum="+e,method:"post"})};var r=a("vLgD")},rBlF:function(e,t){}});
//# sourceMappingURL=9.fbf6051d42afa05a780c.js.map