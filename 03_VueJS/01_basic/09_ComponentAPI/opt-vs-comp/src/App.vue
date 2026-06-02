<template>
  <div>
    <Options />
    <hr />
    <Composition />
    <hr />
    <Calc />
  </div>
</template>

<script>
import Calc from './components/Calc.vue';
import Composition from './components/Composition.vue';
import Options from './components/Options.vue';
export default {
  name: 'App',
  components: { Options, Composition, Calc },
};
</script>
