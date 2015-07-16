/**
 * 
 */
Ext.define('ifeng.model.ReportModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
		'total',
		'valid',
		'skip',
		'data_status',
		'latest_time',
		'create_time'
	]
	
});