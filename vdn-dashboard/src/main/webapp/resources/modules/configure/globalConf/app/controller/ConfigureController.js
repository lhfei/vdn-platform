/*
 * File: app/controller/ConfigureController.js
 *
 * This file was generated by Sencha Architect version 3.2.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('ifeng.controller.ConfigureController', {
    extend: 'Ext.app.Controller',

    stores: ['ConstantStore'],
	models: ['GlobalConstant'],
    views: [
        'GlobalConstantGrid',
        'Viewport',
        'GlobalConstantForm'
    ],
    
    refs: [
       {ref: 'constantForm', selector: 'constantForm'},
       {ref: 'constantStore', selector: 'constantStore'}
	],
	
	init: function() {
		var me = this;
		
		this.control({
			'viewport > constantForm button[action=doRefresh]': {
				click: this.doRefresh
			},
			
		});
	},
	
	onLaunch: function() {
	},
	
	doRefresh: function() {
	}
	
	
});