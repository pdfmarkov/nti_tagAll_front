<template>
	<div id="hat">
		<template v-for="a in authors">
			<author v-bind:name="a.name"
				v-bind:surname="a.surname"
				v-bind:group="a.group"
				v-bind:variant="a.variant"
				v-bind:imageURL="a.imageURL"
				v-bind:profileLink="a.profileLink" />
		</template>
	</div>
</template>

<script>
	import author from '@/components/temp_startup/author'

	export default {
		name: 'hat',
		data: function() {
			return {
				authors: [
					{ 
						name: 'Петр',
						surname: 'Марков',
						group: 'P3210',
						variant: '10113',
						imageURL: 'https://avatars0.githubusercontent.com/u/12988105?s=460&u=a7e09f04ee917e60702fb3e6bab0baf381032863&v=4',
						profileLink: 'https://github.com/pdfmarkov',
					},

					{ 
						name: 'Влад',
						surname: 'Тарасенко',
						group: 'P3210',
						variant: '10113',
						imageURL: 'https://avatars3.githubusercontent.com/u/58933887?s=460&u=7b6e989c1545420a06b4dc55ff1265c873f9ce18&v=4',
						profileLink: 'https://github.com/VladislavByITMO',
					},
				]
			};
		},

		components: {
      author,
		},
	}
</script>

<style>
	#hat {
    width: 100%;
    margin: 4% auto;
	  min-height: 50vh;
    }
</style>