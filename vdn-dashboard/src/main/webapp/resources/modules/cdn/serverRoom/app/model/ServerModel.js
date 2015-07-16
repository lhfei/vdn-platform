/**
 * 
 */
Ext.define('ifeng.model.ServerModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
	    'room_id',
	    'room_name',
		'ip',
		'inner_ip',
		'server_status',
		'data_status',
		'latest_time',
		'create_time'
	]
});