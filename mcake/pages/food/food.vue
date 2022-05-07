<template>
	<view>
		小食
		<u-tag text="标签" plain size="mini" type="warning"></u-tag>
		<u-rate count="5" ></u-rate>
		<!-- <my-comp></my-comp> -->
		<test-my-comp name="无忌"></test-my-comp>
	</view>
</template>

<script>
	import MyComp from '../../components/test-my-comp.vue'
	import testBus from '../../bus/testBus.js'
	export default {
		data() {
			return {
				
			}
		},
		components: { //局部注册
			'my-comp':MyComp
		},
		computed: {
			
		},
		watch:{
			
		},
		methods: {
			
		},
		onLoad() { //生命周期
			console.log('food页面的onLoad');
			testBus.$on('sendData',(data)=>{
				console.log(data);
			})
		},
		onShow(){
			console.log('food页面的onShow');
		},
		onHide(){
			console.log('food页面的onHide');
		}
	}
</script>

<style>

</style>
