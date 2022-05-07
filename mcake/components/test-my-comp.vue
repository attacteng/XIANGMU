<template>
	<view @click="handleNum">
		测试公共组件 ,
		{{name}}
	</view>
</template>

<script>
	export default {
		name:"test-my-comp",
		props:['name'],
		data() {
			return {
				
			};
		},
		computed: {
			
		},
		watch:{
			
		},
		methods: {
			handleNum(){
				this.$emit('onNum',11)
			}
		},
		onLoad() { //不能执行
			console.log('公共组件的onLoad');
		},
		created() {
			console.log('公共组件的created');
		}
	}
</script>

<style lang="scss">

</style>
