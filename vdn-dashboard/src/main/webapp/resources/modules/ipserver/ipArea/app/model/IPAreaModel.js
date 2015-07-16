/**
 * 
 */
Ext.define('ifeng.model.IPAreaModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
		'digest',
		'data_status',
		'latest_time',
		'create_time'
	]
	
});