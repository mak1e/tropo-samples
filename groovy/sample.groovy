answer()
def event=prompt('where are you heading?',
  [repeat:3,choices:"1st Floor (first, house wares, 1),\n 2nd Floor (second, bed and bath, 2),\n 3rd Floor (third, sporting goods, 3)", timeout:10.03456789, 
     onChoices: {event->
     event.onChoice( '1st Floor', { say('Your destination is 1st Floor') } )
     event.onChoice( '2nd Floor', { say('Your destination is 2nd Floor') } )
     event.onChoice( '3rd Floor', { say('Your destination is 3rd Floor') } )
     event.onBadChoice( { say('I can not recognize you. Please input again. ') } ) 
     }, 
     onTimeout: { say('wait input time out') }, 
     onError: { say('You"ve get an error!') },
     onHangup: { println ">>>>>>>>>>>>>>>>>>>>Disconnected by the peer!<<<<<<<<<<<<<<<<<" },
     onEvent: { event->
     if (event.name!="hangup"){ say('inner generic callback got triggered by event ' + event.name)}
     event.onError( { say('000You"ve got an error err! ') } )
     event.onTimeout( { say('000wait input time out') } )
     event.onHangup( { println ">>>>>>>>>>>>>>>>Discnnected by the peer!<<<<<<<<<<<<<<<<<" } )
     event.onChoice( '1st Floor', { say('Your destination is 1st Floor') } )
     event.onChoice( '2nd Floor', { say('Your destination is 2nd Floor') } )
     event.onChoice( '3rd Floor', { say('Your destination is 3rd Floor') } )
     event.onBadChoice( { say('I can not recognize you. Please input again. ') } ) 
     }
    ]
)

if (event.name!="hangup"){ 
  say('outer callback got called for event [' + event.name +',' + event.value +']')
  event.onError( { say('111You"ve got an error err! ') } )
  event.onTimeout( { say('111wait input time out') } )
  event.onChoice( '1st Floor', { say('Your destination is 1st Floor') } )
  event.onChoice( '2nd Floor', { say('Your destination is 2nd Floor') } )
  event.onChoice( '3rd Floor', { say('Your destination is 3rd Floor') } )
  event.onBadChoice( { say('I can not recognize you') } ) 

  say('Thanks for testing Groovy on the Tropo platform')

  hangup()
}
else{
  println ">>>>>>>>>>>>>>>Discnnected by the peer!<<<<<<<<<<<<<<<<<"
}