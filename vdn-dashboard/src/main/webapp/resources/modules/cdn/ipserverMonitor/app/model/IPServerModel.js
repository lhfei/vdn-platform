/**
 * 
 */
Ext.define('ifeng.model.IPServerModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
		'ip',
		'live_total',
		'request_total',
		'video_total',
		'total',
		'data_status',
		'latest_time',
		'create_time'
	]
	
});