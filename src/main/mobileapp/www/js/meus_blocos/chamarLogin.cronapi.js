(function() {
  'use strict';

   /**
   * @categoryName Login
   */
  this.cronapi.myfunctions = {};
  
  /**
   * @type function
   * @name chamarLogin
   * @description Função que chama o login
   * @param {ObjectType.STRING} component Id do botão
   * @multilayer true
   */
  this.cronapi.myfunctions.chamarLogin = function(/** @type {ObjectType.OBJECT} @blockType ids_from_screen*/ id) {
   $('#'+id).trigger('click');
  };
  

}).bind(window)();