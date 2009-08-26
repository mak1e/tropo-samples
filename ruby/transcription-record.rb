answer
say 'Welcome to ruby recording test'

event = record('Say something after the beep.',
               { :repeat              => 0, 
                 :bargein             => true, 
                 :beep                => true, 
                 :silenceTimeout      => 2, 
                 :maxTime             => 30, 
                 :timeout             => 4.03456789, 
                 :recordURI           => 'http://tropo.to-a-domain.com/post_audio?filename=file123456.wav',
                 :transcriptionOutURI => 'http://tropo.to-a-domain.com/receive_transcription', 
                 :transcriptionID     => '123456' })

log 'Recorded file: ' + event.recordURI
say 'Thanks for your testing ruby on Tropo platform'
hangup